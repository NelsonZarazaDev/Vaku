CREATE TABLE notification
(
    id                 uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    title              VARCHAR(254)                   NOT NULL,
    message            TEXT                           NOT NULL,
    type               VARCHAR(80)                    NOT NULL,
    priority           VARCHAR(50)                    NOT NULL,
    create_employee_id uuid                           NOT NULL,
    is_global          BOOLEAN                        NOT NULL,
    health_center_id   uuid                           NOT NULL,
    created_at         TIMESTAMPTZ      DEFAULT now() NOT NULL
);

CREATE TABLE notification_recipient
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    is_read          BOOLEAN     NOT NULL,
    read_at          TIMESTAMPTZ NOT NULL,
    health_center_id uuid        NOT NULL,
    notification_id  uuid        NOT NULL,
    person_id        uuid        NOT NULL,
    CONSTRAINT fk_notification_recipient FOREIGN KEY (notification_id) REFERENCES notification (id)
)