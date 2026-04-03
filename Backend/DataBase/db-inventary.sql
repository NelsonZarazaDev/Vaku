CREATE TABLE inventory
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    date             TIMESTAMPTZ                    NOT NULL,
    employee_id      uuid                           NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL
);

CREATE INDEX idx_inventory_employee_id ON inventory (employee_id);
CREATE INDEX idx_inventory_health_center_id ON inventory (health_center_id);

CREATE TABLE vaccines
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name             VARCHAR(100)                   NOT NULL,
    description      VARCHAR(254)                   NOT NULL,
    age_dose         SMALLINT                       NOT NULL,
    status           BOOLEAN          DEFAULT true  NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at        TIMESTAMPTZ
);

CREATE INDEX idx_vaccines_health_center_id ON vaccines (health_center_id);


CREATE TABLE inventory_vaccines
(
    id                uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    laboratory        VARCHAR(254)                   NOT NULL,
    batch             VARCHAR(50)                    NOT NULL,
    expiration_date   DATE                           NOT NULL,
    registration_time DATE                           NOT NULL,
    amount            INT                            NOT NULL,
    reason            TEXT                           NOT NULL,
    status            BOOLEAN          DEFAULT true  NOT NULL,
    health_center_id  uuid                           NOT NULL,
    inventory_id      uuid                           NOT NULL,
    vaccine_id        uuid                           NOT NULL,
    created_at        TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at         TIMESTAMPTZ,
    CONSTRAINT fk_inventory_id FOREIGN KEY (inventory_id) REFERENCES inventory (id),
    CONSTRAINT fk_vaccines FOREIGN KEY (vaccine_id) REFERENCES vaccines (id)
);

CREATE INDEX idx_inventory_vaccines_inventory_id ON inventory_vaccines (inventory_id);
CREATE INDEX idx_inventory_vaccines_vaccine_id ON inventory_vaccines (vaccine_id);
CREATE INDEX idx_inventory_vaccines_health_center_id ON inventory_vaccines (health_center_id);