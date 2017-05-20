CREATE SEQUENCE listicle.s_country_id START WITH 1;

CREATE TABLE listicle.country (
  id BIGINT NOT NULL,
  iso_3166_alpha2 CHAR(2),
  iso_3166_alpha3 CHAR(3),
  name TEXT,
  CONSTRAINT pk_country PRIMARY KEY (id)
);

CREATE UNIQUE INDEX unq_country_alpha2 ON listicle.country (iso_3166_alpha2);
CREATE UNIQUE INDEX unq_country_alpha3 ON listicle.country (iso_3166_alpha3);