
create table deployed_levels (
  id uuid not null,
  name VARCHAR(255),
  description VARCHAR(1000)
);

create table deployable_features (
   id uuid not null,
   flag_id uuid not null,
   flag_name VARCHAR(255) not null
);
alter table deployable_features add column deployed_level_id UUID NULL;
alter table deployable_features add foreign key (deployed_level_id) references deployed_levels(id);