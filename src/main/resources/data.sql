insert into ceo (id, first_name, last_name) values
(-1, 'Arnold', 'Szwarceneger');

insert into brand (id, name, origin, ceo_id) values
(-1, 'Mazda', 'JAPAN', -1),
(-2, 'Pegeout', 'FRANCE', null),
(-3, 'Citroen', 'FRANCE', null);

insert into model (id, name, brand_id) values
(-1, '6', -1),
(-2, 'CX-5', -1),
(-3, '508 SW', -2),
(-4, 'Cactus', -3);

insert into engine (code, type) values
('SKYACTIV—G 2.0', 'PETROL'),
('SKYACTIV-G 2.5', 'PETROL'),
('SKYACTIV-D 2.2', 'DIESEL');