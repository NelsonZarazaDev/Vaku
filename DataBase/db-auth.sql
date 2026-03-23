CREATE TABLE permits
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name             VARCHAR(50)                    NOT NULL,
    permit           JSONB                          NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at        TIMESTAMPTZ
);

CREATE TABLE role
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name             VARCHAR(100)                   NOT NULL,
    status           BOOLEAN          DEFAULT true  NOT NULL,
    health_center_id uuid                           NOT NULL,
    permits_id       uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at        TIMESTAMPTZ,
    CONSTRAINT fk_permits_id FOREIGN KEY (id) REFERENCES permits (id)
);

CREATE TABLE auth_method
(
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    type       VARCHAR(50)                    NOT NULL,
    identifier VARCHAR(254)                   NOT NULL,
    secret     VARCHAR(50)                    NOT NULL,
    person_id  uuid                           NOT NULL,
    role_id    uuid                           NOT NULL,
    created_at TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at  TIMESTAMPTZ,
    delete_at  TIMESTAMPTZ,
    CONSTRAINT fk_role_id FOREIGN KEY (id) REFERENCES role (id),
    CONSTRAINT uq_identifier_auth_method UNIQUE (identifier)
)