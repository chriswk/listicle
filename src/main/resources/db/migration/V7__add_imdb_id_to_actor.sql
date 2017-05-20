ALTER TABLE listicle.actor ADD column imdb_id TEXT;
CREATE UNIQUE INDEX unq_actor_imdb_id_idx ON listicle.actor (imdb_id);