CREATE TABLE permits_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE role_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE auth_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE inventory_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE vaccines_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE inventory_vaccines_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE notification_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE notification_recipient_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE document_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE health_center_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);

CREATE TABLE vaccine_registration_applied_logs
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
    ip_address       VARCHAR(50)                    NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    source_service   VARCHAR(50)                    NOT NULL
);