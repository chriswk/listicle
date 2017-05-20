ALTER TABLE listicle.country ADD last_changed timestamp without TIME ZONE default (now() at time zone 'utc');
ALTER TABLE listicle.country ADD created timestamp without TIME ZONE default (now() at time zone 'utc');
ALTER table listicle.actor ADD last_changed timestamp without TIME ZONE DEFAULT (now() at time zone 'utc');
ALTER table listicle.actor ADD created timestamp without TIME ZONE DEFAULT (now() at time zone 'utc');