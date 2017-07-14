ALTER TABLE listicle.country ADD last_changed timestamp default now();
ALTER TABLE listicle.country ADD created timestamp default now();
ALTER table listicle.actor ADD last_changed timestamp DEFAULT now();
ALTER table listicle.actor ADD created timestamp DEFAULT now();