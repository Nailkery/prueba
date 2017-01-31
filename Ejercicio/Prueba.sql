
--tabla bibliotecas
create table "biblioteca"
  ( "id" bigserial not null,
    "nombre" character varying(150) not null
    );


--tabla libro
  create table "libro"
  ( "id" bigserial not null,
    "nombre" character varying(150) not null,
    "paginas" integer not null,
    "biblioteca_id" bigint not null,
    "autor_id" bigint not null
    );

--tabla autor
  create table "autor"
  ( "id" bigserial not null,
    "nombre" character varying(150) not null,
    "edad" integer not null
    );


--tabla lector_libro
  create table "lector_libro"
  ( "id" bigserial not null,
    "id_libro" bigint not null,
    "id_lector" bigint not null,
    "comentario" character varying(255) not null
    );

  
--tabla lector
  create table "lector"
  ( "id" bigserial not null,
    "nombre" character varying(150) not null,
    "correo" character varying(150) not null
    );


ALTER TABLE biblioteca ADD PRIMARY KEY(id);
ALTER TABLE libro ADD PRIMARY KEY(id);
ALTER TABLE autor ADD PRIMARY KEY(id);
ALTER TABLE lector_libro ADD PRIMARY KEY(id);
ALTER TABLE lector ADD PRIMARY KEY(id);




ALTER TABLE libro ADD FOREIGN KEY (biblioteca_id) REFERENCES biblioteca (id) MATCH FULL;
ALTER TABLE libro ADD FOREIGN KEY (autor_id) REFERENCES autor (id) MATCH FULL;
ALTER TABLE lector_libro ADD  FOREIGN KEY (id_lector) REFERENCES lector (id) MATCH FULL;
ALTER TABLE lector_libro ADD  FOREIGN KEY (id_libro) REFERENCES libro (id) MATCH FULL;

