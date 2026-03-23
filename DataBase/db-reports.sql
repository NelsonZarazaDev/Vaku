CREATE TABLE department
(
    id   uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(2)  NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT uq_code_department UNIQUE (code)
);

CREATE TABLE city
(
    id            uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    code          VARCHAR(5)  NOT NULL,
    name          VARCHAR(50) NOT NULL,
    department_id uuid        NOT NULL,
    CONSTRAINT uq_code_city UNIQUE (code),
    CONSTRAINT fk_department_id FOREIGN KEY (department_id) REFERENCES department (id)
);

CREATE TABLE blood_type
(
    id   uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL,
    CONSTRAINT uq_name_blood_type UNIQUE (name)
);

CREATE TABLE document_type
(
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    code       VARCHAR(10)  NOT NULL,
    name       VARCHAR(50)  NOT NULL,
    regex      VARCHAR(255) NOT NULL,
    min_length SMALLINT     NOT NULL,
    max_length SMALLINT     NOT NULL
);

CREATE TABLE health_center
(
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name       VARCHAR(255)                   NOT NULL,
    status     BOOLEAN          DEFAULT true  NOT NULL,
    city_id    uuid                           NOT NULL,
    created_at TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at  TIMESTAMPTZ,
    delete_at  TIMESTAMPTZ,
    CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES city (id)
);

CREATE TABLE permits
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name             VARCHAR(50)                    NOT NULL,
    permit           JSONB                          NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at        TIMESTAMPTZ,
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
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
    CONSTRAINT fk_permits_id FOREIGN KEY (id) REFERENCES permits (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE TABLE person
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name       VARCHAR(100)                   NOT NULL,
    last_name        VARCHAR(100)                   NOT NULL,
    date_birth       DATE                           NOT NULL,
    document         VARCHAR(30)                    NOT NULL,
    gender           CHAR(1)                        NOT NULL,
    address          VARCHAR(50)                    NOT NULL,
    phone            VARCHAR(20) CHECK (phone ~ '^\+[1-9]\d{7,19}$'),
    city_id          uuid                           NOT NULL,
    document_type_id uuid                           NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at        TIMESTAMPTZ,
    CONSTRAINT ch_gender CHECK ( gender IN ('F', 'M') ),
    CONSTRAINT uq_document_person UNIQUE (document),
    CONSTRAINT uq_phone_person UNIQUE (phone),
    CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES city (id),
    CONSTRAINT fk_document_type_id FOREIGN KEY (document_type_id) REFERENCES document_type (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE TABLE patient
(
    id               uuid PRIMARY KEY,
    weight           NUMERIC(5, 2)             NOT NULL,
    height           NUMERIC(5, 2)             NOT NULL,
    guardian         VARCHAR(255)              NOT NULL,
    email            VARCHAR(255)              NOT NULL,
    live             BOOLEAN     DEFAULT true  NOT NULL,
    blood_type_id    uuid                      NOT NULL,
    health_center_id uuid                      NOT NULL,
    created_at       TIMESTAMPTZ DEFAULT now() NOT NULL,
    update_at        TIMESTAMPTZ,
    CONSTRAINT uq_email_patient UNIQUE (email),
    CONSTRAINT fk_person_id FOREIGN KEY (id) REFERENCES person (id),
    CONSTRAINT fk_blood_type_id FOREIGN KEY (id) REFERENCES blood_type (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE TABLE employee
(
    id               uuid PRIMARY KEY,
    status           BOOLEAN                   NOT NULL,
    date_admission   TIMESTAMPTZ               NOT NULL,
    health_center_id uuid                      NOT NULL,
    created_at       TIMESTAMPTZ DEFAULT now() NOT NULL,
    update_at        TIMESTAMPTZ,
    CONSTRAINT fk_employee_id FOREIGN KEY (id) REFERENCES person (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE TABLE inventory
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    date             TIMESTAMPTZ                    NOT NULL,
    employee_id      uuid                           NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE TABLE vaccines
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name             VARCHAR(100)                   NOT NULL,
    description      VARCHAR(255)                   NOT NULL,
    age_dose         SMALLINT                       NOT NULL,
    status           BOOLEAN          DEFAULT true  NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at        TIMESTAMPTZ,
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE TABLE inventory_vaccines
(
    id                uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    laboratory        VARCHAR(255)                   NOT NULL,
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
    CONSTRAINT fk_vaccines FOREIGN KEY (vaccine_id) REFERENCES vaccines (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);


CREATE TABLE vaccine_registration_applied
(
    id                    uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    application_date      timestamptz                    NOT NULL,
    date_appointment      timestamptz,
    person_id             uuid                           NOT NULL,
    health_center_id      uuid                           NOT NULL,
    employee_id           uuid                           NOT NULL,
    inventory_vaccines_id uuid                           NOT NULL,
    created_at            TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at             TIMESTAMPTZ,
    CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES person (id),
    CONSTRAINT fk_employee_id FOREIGN KEY (employee_id) REFERENCES employee (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id),
    CONSTRAINT fk_inventory_vaccines_id FOREIGN KEY (inventory_vaccines_id) REFERENCES inventory_vaccines (id)
);