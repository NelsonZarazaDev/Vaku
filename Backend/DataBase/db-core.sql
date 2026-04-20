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
    country_id INT         NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE city
(
    id            SERIAL PRIMARY KEY,
    name          VARCHAR(50) NOT NULL,
    department_id INT         NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department (id)
);

CREATE TABLE document_type
(
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    code       VARCHAR(10)  NOT NULL,
    name       VARCHAR(50)  NOT NULL,
    regex      VARCHAR(255) NOT NULL,
    min_length SMALLINT     NOT NULL,
    max_length SMALLINT     NOT NULL,
    country_id INT          NOT NULL,
    CONSTRAINT fk_country_id FOREIGN KEY (country_id) REFERENCES country (id)
);

CREATE TABLE blood_type
(
    id   uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL,
    CONSTRAINT uq_name_blood_type UNIQUE (name)
);

CREATE TABLE health_center
(
    id         uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name       VARCHAR(255)                   NOT NULL,
    status     BOOLEAN          DEFAULT true  NOT NULL,
    city_id    INT                            NOT NULL,
    created_at TIMESTAMPTZ      DEFAULT now() NOT NULL,
    update_at  TIMESTAMPTZ,
    delete_at  TIMESTAMPTZ,
    CONSTRAINT fk_city_id FOREIGN KEY (city_id) REFERENCES city (id)
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
    city_id          INT                            NOT NULL,
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
    update_at        TIMESTAMPTZ,
    CONSTRAINT uq_email_patient UNIQUE (email),
    CONSTRAINT fk_person_id FOREIGN KEY (id) REFERENCES person (id),
    CONSTRAINT fk_blood_type_id FOREIGN KEY (blood_type_id) REFERENCES blood_type (id)
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
    update_at        TIMESTAMPTZ,
    CONSTRAINT fk_employee_id FOREIGN KEY (id) REFERENCES person (id),
    CONSTRAINT fk_employee_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);

CREATE INDEX idx_employee_health_center_id ON employee (health_center_id);

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
    CONSTRAINT fk_health_center_id FOREIGN KEY (health_center_id) REFERENCES health_center (id)
);