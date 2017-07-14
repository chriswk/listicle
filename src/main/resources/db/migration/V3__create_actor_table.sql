CREATE SEQUENCE listicle.s_actor_id START WITH 100;

CREATE TABLE listicle.actor (
  id BIGINT NOT NULL,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  birth_date DATE,
  country_id BIGINT,

  CONSTRAINT pk_actor PRIMARY KEY (id),
  CONSTRAINT fk_actor_country_id FOREIGN KEY (country_id) REFERENCES listicle.country(id)

)