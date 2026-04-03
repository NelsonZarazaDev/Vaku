CREATE TABLE country
(
    id         SERIAL PRIMARY KEY,
    name       varchar(150) NOT NULL,
    cod_iso2   char(2)      NOT NULL UNIQUE,
    cod_iso3   char(3)      NOT NULL UNIQUE,
    phone_code VARCHAR(5)   NOT NULL
);

CREATE TABLE department
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    country_id INT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country(id)
);

CREATE TABLE city
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(50) NOT NULL,
    department_id INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department(id)
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
    max_length SMALLINT     NOT NULL,
    country_id varchar(5)   NOT NULL,
    CONSTRAINT fk_country_id FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE health_center
(
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name       VARCHAR(255)                   NOT NULL,
    status     BOOLEAN          DEFAULT true  NOT NULL,
    city_id    VARCHAR(5)                     NOT NULL,
    created_at TIMESTAMPTZ      DEFAULT now() NOT NULL,
    updated_at TIMESTAMPTZ,
    CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES city (id)
);

CREATE TABLE permits
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name             VARCHAR(50)                    NOT NULL,
    permit           JSONB                          NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    updated_at       TIMESTAMPTZ,
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
    updated_at       TIMESTAMPTZ,
    CONSTRAINT fk_permits_id FOREIGN KEY (permits_id) REFERENCES permits (id),
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
    phone            VARCHAR(20),
    city_id          VARCHAR(5)                     NOT NULL,
    document_type_id uuid                           NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    updated_at       TIMESTAMPTZ,
    CONSTRAINT ch_gender CHECK ( gender IN ('F', 'M') ),
    CONSTRAINT uq_document_person UNIQUE (document),
    CONSTRAINT uq_phone_person UNIQUE (phone),
    CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES city (id),
    CONSTRAINT fk_document_type_id FOREIGN KEY (document_type_id) REFERENCES document_type (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE INDEX idx_person_city_id ON person (city_id);
CREATE INDEX idx_person_document_type_id ON person (document_type_id);
CREATE INDEX idx_person_health_center_id ON person (health_center_id);
CREATE INDEX idx_person_document ON person (document);

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
    updated_at       TIMESTAMPTZ,
    CONSTRAINT uq_email_patient UNIQUE (email),
    CONSTRAINT fk_person_id FOREIGN KEY (id) REFERENCES person (id),
    CONSTRAINT fk_blood_type_id FOREIGN KEY (blood_type_id) REFERENCES blood_type (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE INDEX idx_patient_health_center_id ON patient (health_center_id);
CREATE INDEX idx_patient_blood_type_id ON patient (blood_type_id);

CREATE TABLE employee
(
    id               uuid PRIMARY KEY,
    status           BOOLEAN                   NOT NULL,
    date_admission   TIMESTAMPTZ               NOT NULL,
    health_center_id uuid                      NOT NULL,
    created_at       TIMESTAMPTZ DEFAULT now() NOT NULL,
    updated_at       TIMESTAMPTZ,
    CONSTRAINT fk_employee_id FOREIGN KEY (id) REFERENCES person (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE INDEX idx_employee_health_center_id ON employee (health_center_id);


CREATE TABLE inventory
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    date             TIMESTAMPTZ                    NOT NULL,
    employee_id      uuid                           NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE INDEX idx_inventory_health_center_id ON inventory (health_center_id);
CREATE INDEX idx_inventory_employee_id ON inventory (employee_id);

CREATE TABLE vaccines
(
    id               uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name             VARCHAR(100)                   NOT NULL,
    description      VARCHAR(255)                   NOT NULL,
    age_dose         SMALLINT                       NOT NULL,
    status           BOOLEAN          DEFAULT true  NOT NULL,
    health_center_id uuid                           NOT NULL,
    created_at       TIMESTAMPTZ      DEFAULT now() NOT NULL,
    updated_at       TIMESTAMPTZ,
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE INDEX idx_vaccines_health_center_id ON vaccines (health_center_id);

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
    updated_at        TIMESTAMPTZ,
    CONSTRAINT fk_inventory_id FOREIGN KEY (inventory_id) REFERENCES inventory (id),
    CONSTRAINT fk_vaccines FOREIGN KEY (vaccine_id) REFERENCES vaccines (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE INDEX idx_inventory_vaccines_inventory_id ON inventory_vaccines (inventory_id);
CREATE INDEX idx_inventory_vaccines_vaccine_id ON inventory_vaccines (vaccine_id);
CREATE INDEX idx_inventory_vaccines_health_center_id ON inventory_vaccines (health_center_id);
CREATE INDEX idx_inventory_vaccines_expiration_date ON inventory_vaccines (expiration_date);


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
    updated_at            TIMESTAMPTZ,
    CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES person (id),
    CONSTRAINT fk_employee_id FOREIGN KEY (employee_id) REFERENCES employee (id),
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id),
    CONSTRAINT fk_inventory_vaccines_id FOREIGN KEY (inventory_vaccines_id) REFERENCES inventory_vaccines (id)
);

-- Índices para búsquedas frecuentes por identificador
CREATE INDEX idx_vaccine_reg_person_id ON vaccine_registration_applied (person_id);
CREATE INDEX idx_vaccine_reg_health_center_id ON vaccine_registration_applied (health_center_id);
CREATE INDEX idx_vaccine_reg_employee_id ON vaccine_registration_applied (employee_id);
CREATE INDEX idx_vaccine_reg_inventory_vaccines_id ON vaccine_registration_applied (inventory_vaccines_id);
CREATE INDEX idx_vaccine_reg_application_date ON vaccine_registration_applied (application_date);
CREATE INDEX idx_vaccine_reg_person_date ON vaccine_registration_applied (person_id, application_date);