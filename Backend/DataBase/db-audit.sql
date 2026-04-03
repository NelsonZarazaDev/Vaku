CREATE TABLE audit_logs
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    event_type       VARCHAR(20)                    NOT NULL,
    entity_name      VARCHAR(50)                    NOT NULL,
    action           VARCHAR(20)                    NOT NULL,
    old_data         JSONB,
    new_data         JSONB                          NOT NULL,
    entity_id        uuid                           NOT NULL,
    user_id          uuid                           NOT NULL,
    health_center_id uuid                           NOT NULL,
    ip_address       inet                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE INDEX idx_audit_logs_user_id ON audit_logs (user_id);
CREATE INDEX idx_audit_logs_entity_id ON audit_logs (entity_id);
CREATE INDEX idx_audit_logs_health_center_id ON audit_logs (health_center_id);
CREATE INDEX idx_audit_logs_created_at ON audit_logs USING BRIN (created_at);
CREATE INDEX idx_audit_logs_entity_created_at ON audit_logs (entity_id, created_at);

CREATE USER vakuRead WITH PASSWORD 'FY&%13#@23of0w#';
REVOKE ALL ON TABLE audit_logs FROM PUBLIC;
GRANT INSERT, SELECT ON TABLE audit_logs TO vakuRead;


CREATE OR REPLACE FUNCTION prot_audit_unchanging()
RETURNS TRIGGER AS $$BEGIN
    IF (TG_OP = 'UPDATE' OR TG_OP = 'DELETE' OR TG_OP = 'TRUNCATE') THEN
        RAISE EXCEPTION 'The % operator is not allowed in audit_logs', TG_OP;
    END IF;
    RETURN NULL;
END;$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_audit_logs_unchanging
BEFORE UPDATE OR DELETE OR TRUNCATE ON audit_logs
FOR EACH STATEMENT EXECUTE FUNCTION prot_audit_unchanging();



CREATE POLICY "insertion_and_reading_only" ON audit_logs
    FOR ALL
    TO vakuRead
    USING (true)
    WITH CHECK (false);


ALTER TABLE audit_logs FORCE ROW LEVEL SECURITY;

SELECT tgname, tgenabled
FROM pg_trigger
WHERE tgrelid = 'audit_logs'::regclass;