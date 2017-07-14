ALTER TABLE listicle.actor ADD column imdb_id varchar(20);
CREATE UNIQUE INDEX unq_actor_imdb_id_idx ON listicle.actor (imdb_id);