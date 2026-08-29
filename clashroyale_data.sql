-- ============================================================
-- Base de datos: Clash Royale API
-- Universo: Clash Royale / Clash of Clans
-- Entidades: Peleador, Ataque, Arma (+ tablas intermedias)
-- ============================================================

-- ------------------------------------------------------------
-- Creación de tablas
-- ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS arma (
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre            VARCHAR(100) NOT NULL,
    bonificador_danio INT          NOT NULL,
    peso              FLOAT        NOT NULL
);

CREATE TABLE IF NOT EXISTS ataque (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(100) NOT NULL,
    costo_energia INT          NOT NULL,
    danio_base    INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS peleador (
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre       VARCHAR(100) NOT NULL,
    puntos_vida  INT          NOT NULL,
    energia      INT          NOT NULL,
    defensa_base FLOAT        NOT NULL
);

CREATE TABLE IF NOT EXISTS peleador_arma (
    peleador_id BIGINT NOT NULL,
    arma_id     BIGINT NOT NULL,
    PRIMARY KEY (peleador_id, arma_id),
    FOREIGN KEY (peleador_id) REFERENCES peleador(id),
    FOREIGN KEY (arma_id)     REFERENCES arma(id)
);

CREATE TABLE IF NOT EXISTS peleador_ataque (
    peleador_id BIGINT NOT NULL,
    ataque_id   BIGINT NOT NULL,
    PRIMARY KEY (peleador_id, ataque_id),
    FOREIGN KEY (peleador_id) REFERENCES peleador(id),
    FOREIGN KEY (ataque_id)   REFERENCES ataque(id)
);

-- ------------------------------------------------------------
-- INSERT: Arma (50 registros) — armas del universo CR/CoC
-- Campos: nombre | bonificador_danio | peso
-- ------------------------------------------------------------

INSERT INTO arma (nombre, bonificador_danio, peso) VALUES
('Espada del Príncipe',          40,  5.5),  -- 1
('Lanza del Caballero',          28,  4.0),  -- 2
('Hacha del Bravucón',           35,  6.0),  -- 3
('Martillo del Gigante',         60,  9.5),  -- 4
('Arco del Arquero',             20,  1.5),  -- 5
('Ballesta Goblin',              22,  2.0),  -- 6
('Martillo de Minero',           38,  7.0),  -- 7
('Lanza del Espadachín',         25,  3.5),  -- 8
('Espada del Príncipe Oscuro',   55,  6.5),  -- 9
('Hacha del Bárbaro',            42,  7.5),  -- 10
('Martillo del Rey Bárbaro',     70, 10.0),  -- 11
('Espada de la Reina Arquera',   30,  3.0),  -- 12
('Lanza del Pekka',              65,  8.5),  -- 13
('Bola de Cañón',                50,  8.0),  -- 14
('Martillo del Minero Real',     45,  7.2),  -- 15
('Ballesta de la Torre',         55,  9.0),  -- 16
('Espada Fantasma',              33,  2.8),  -- 17
('Hacha del Leñador',            40,  6.8),  -- 18
('Lanza del Caballero Hielo',    30,  4.5),  -- 19
('Arco de Energía',              25,  1.8),  -- 20
('Espada del Campeón',           48,  5.8),  -- 21
('Mayal del Gigante de Piedra',  58,  9.2),  -- 22
('Hacha del Mini Pekka',         44,  6.2),  -- 23
('Lanza del Valkiria',           36,  5.0),  -- 24
('Tridente del Drag Baby',       20,  1.2),  -- 25
('Garra del Gigante Eléctrico',  52,  8.8),  -- 26
('Espada del Cazador Real',      35,  4.2),  -- 27
('Hacha del Bárbaro Barril',     32,  5.5),  -- 28
('Lanza del Esqueleto',          10,  0.8),  -- 29
('Arco de Nieve',                22,  1.6),  -- 30
('Martillo del Constructor',     28,  4.0),  -- 31
('Espada de la Magia Real',      38,  3.5),  -- 32
('Hacha del Oso Garra',          46,  7.8),  -- 33
('Lanza del Guardia Real',       30,  4.3),  -- 34
('Bastón del Mago',              35,  2.5),  -- 35
('Sable del Pirata',             27,  3.2),  -- 36
('Arco del Cazador',             24,  1.7),  -- 37
('Espada del Electro Gigante',   56,  9.0),  -- 38
('Hacha del Troll',              34,  5.9),  -- 39
('Mayal del Gigante Lechero',    48,  8.3),  -- 40
('Cañón Goblin',                 60,  8.6),  -- 41
('Lanza de la Guardia Esqueleto',12,  0.9),  -- 42
('Espada del Electro Dragón',    50,  7.0),  -- 43
('Hacha del Super Bárbaro',      62,  9.8),  -- 44
('Arco del Super Arquero',       32,  2.2),  -- 45
('Martillo del Super Gigante',   72, 10.5),  -- 46
('Espada del Super Mini Pekka',  54,  7.3),  -- 47
('Lanza del Super Valkiria',     44,  5.7),  -- 48
('Bastón del Mago Real',         40,  2.8),  -- 49
('Hacha del Bárbaro Legendario', 68,  9.6);  -- 50

-- ------------------------------------------------------------
-- INSERT: Ataque (50 registros) — habilidades del universo CR/CoC
-- Campos: nombre | costo_energia | danio_base
-- ------------------------------------------------------------

INSERT INTO ataque (nombre, costo_energia, danio_base) VALUES
('Carga del Príncipe',           20,  70),   -- 1
('Flecha de la Arquera',         10,  35),   -- 2
('Avalancha del Gigante',        35,  90),   -- 3
('Explosión Goblin',             15,  45),   -- 4
('Rugido Bárbaro',               25,  60),   -- 5
('Llama del Dragón',             40, 105),   -- 6
('Ataque de la Bruja',           30,  75),   -- 7
('Golpe Sísmico del Pekka',      50, 130),   -- 8
('Boomerang del Bárbaro',        18,  52),   -- 9
('Flecha de Hielo',              22,  58),   -- 10
('Rayo de la Reina Arquera',     35,  88),   -- 11
('Magia de la Bruja de Hielo',   38,  82),   -- 12
('Salto del Príncipe Oscuro',    28,  72),   -- 13
('Bola de Fuego',                45, 110),   -- 14
('Disparo de Cañón',             30,  80),   -- 15
('Rayo de Zap',                  20,  55),   -- 16
('Tornado Valkiria',             33,  85),   -- 17
('Golpe del Leñador',            28,  74),   -- 18
('Explosion de Barril Goblin',   25,  65),   -- 19
('Descarga Eléctrica',           42, 108),   -- 20
('Tiro Múltiple del Mosquetero', 22,  60),   -- 21
('Salto del Minero',             18,  50),   -- 22
('Rampage del Super Bárbaro',    48, 115),   -- 23
('Ráfaga del Electro Dragón',    55, 135),   -- 24
('Golpe del Gigante Eléctrico',  40, 100),   -- 25
('Cañonazo Goblin',              30,  78),   -- 26
('Esqueletos de la Bruja',       20,  48),   -- 27
('Ataque Oscuro del Pekka',      55, 132),   -- 28
('Flecha de Nieve',              15,  42),   -- 29
('Rugido del Rey Bárbaro',       45, 112),   -- 30
('Curación de la Reina',         30,   0),   -- 31
('Terremoto del Constructor',    38,  92),   -- 32
('Mordida del Drag Baby',        12,  36),   -- 33
('Disparo del Cazador Real',     22,  62),   -- 34
('Magia de Hielo del Mago',      35,  88),   -- 35
('Espíritu del Electro',         18,  50),   -- 36
('Golpe del Campeon',            40, 102),   -- 37
('Lluvia de Flechas',            28,  72),   -- 38
('Explosión Minera',             32,  84),   -- 39
('Super Carga del Príncipe',     50, 125),   -- 40
('Ataque de Oso Garra',          35,  90),   -- 41
('Bomba del Minero Goblin',      25,  67),   -- 42
('Lanza de Caballero Hielo',     20,  54),   -- 43
('Disparo de la Ballesta',       45, 112),   -- 44
('Magia Oscura del Brujo',       42, 106),   -- 45
('Torbellino Valkiria',          38,  96),   -- 46
('Carga del Gigante de Piedra',  52, 128),   -- 47
('Flecha Fantasma',              15,  44),   -- 48
('Explosión del Super Pekka',    60, 140),   -- 49
('Rayo del Mago Real',           48, 118);   -- 50

-- ------------------------------------------------------------
-- INSERT: Peleador (50 registros) — personajes CR/CoC canónicos
-- Campos: nombre | puntos_vida | energia | defensa_base
-- ------------------------------------------------------------

INSERT INTO peleador (nombre, puntos_vida, energia, defensa_base, url_imagen) VALUES
('Príncipe',              1400, 100, 18.0, 'https://static.wikia.nocookie.net/clashroyale/images/b/be/PrinceCard.png/revision/latest'),   -- 1
('Arquera',                750,  90,  9.0, 'https://static.wikia.nocookie.net/clashroyale/images/a/af/ArchersCard.png/revision/latest'),   -- 2
('Gigante',               2000, 110, 28.0, 'https://static.wikia.nocookie.net/clashroyale/images/b/b1/GiantCard.png/revision/latest'),   -- 3
('Príncipe Oscuro',       1350, 105, 17.5, 'https://static.wikia.nocookie.net/clashroyale/images/4/46/DarkPrinceCard.png/revision/latest'),   -- 4
('Espadachín',             680,  85,  8.5, 'https://static.wikia.nocookie.net/clashroyale/images/3/37/SpearGoblinsCard.png/revision/latest'),   -- 5
('Caballero',             1200, 100, 16.0, 'https://static.wikia.nocookie.net/clashroyale/images/5/54/KnightCard.png/revision/latest'),   -- 6
('Mini PEKKA',            1100, 100, 15.0, 'https://static.wikia.nocookie.net/clashroyale/images/7/7b/MiniPEKKACard.png/revision/latest'),   -- 7
('Valkiria',              1250,  98, 16.5, 'https://static.wikia.nocookie.net/clashroyale/images/e/e2/ValkyrieCard.png/revision/latest'),   -- 8
('PEKKA',                 2500, 115, 32.0, 'https://static.wikia.nocookie.net/clashroyale/images/f/fe/PEKKACard.png/revision/latest'),   -- 9
('Bebé Dragón',            800, 108, 11.0, 'https://static.wikia.nocookie.net/clashroyale/images/3/35/BabyDragonCard.png/revision/latest'),   -- 10
('Mosquetero',             700,  88, 10.0, 'https://static.wikia.nocookie.net/clashroyale/images/e/ee/MusketeerCard.png/revision/latest'),   -- 11
('Bruja',                  900, 120, 12.0, 'https://static.wikia.nocookie.net/clashroyale/images/7/7f/WitchCard.png/revision/latest'),   -- 12
('Gigante de Piedra',     2200, 112, 30.0, 'https://static.wikia.nocookie.net/clashroyale/images/d/d4/GolemCard.png/revision/latest'),   -- 13
('Leñador',               1050, 102, 14.0, 'https://static.wikia.nocookie.net/clashroyale/images/5/52/LumberjackCard.png/revision/latest'),   -- 14
('Minero',                 950,  95, 13.5, 'https://static.wikia.nocookie.net/clashroyale/images/2/21/MinerCard.png/revision/latest'),   -- 15
('Gigante Eléctrico',     2100, 110, 29.0, 'https://static.wikia.nocookie.net/clashroyale/images/0/08/ElectroGiantCard.png/revision/latest'),   -- 16
('Bruja de Hielo',         850, 118, 11.5, 'https://static.wikia.nocookie.net/clashroyale/images/d/d3/IceWizardCard.png/revision/latest'),   -- 17
('Bárbaro',               1000,  96, 13.0, 'https://static.wikia.nocookie.net/clashroyale/images/2/2e/BarbariansCard.png/revision/latest'),   -- 18
('Esqueleto',              200,  70,  2.0, 'https://static.wikia.nocookie.net/clashroyale/images/f/f0/SkeletonsCard.png/revision/latest'),   -- 19
('Goblin',                 300,  75,  4.0, 'https://static.wikia.nocookie.net/clashroyale/images/b/bd/GoblinsCard.png/revision/latest'),   -- 20
('Drag Baby',              500, 100,  7.0, 'https://static.wikia.nocookie.net/clashroyale/images/3/35/BabyDragonCard.png/revision/latest'),   -- 21
('Caballero de Hielo',    1100, 100, 15.5, 'https://static.wikia.nocookie.net/clashroyale/images/5/5f/IceGolemCard.png/revision/latest'),   -- 22
('Cazador Real',           950,  92, 12.5, 'https://static.wikia.nocookie.net/clashroyale/images/6/64/HunterCard.png/revision/latest'),   -- 23
('Guardia Real',          1050,  97, 14.5, 'https://static.wikia.nocookie.net/clashroyale/images/5/51/GuardsCard.png/revision/latest'),   -- 24
('Super Bárbaro',         1700, 108, 23.0, 'https://static.wikia.nocookie.net/clashroyale/images/2/2e/BarbariansCard.png/revision/latest'),   -- 25
('Super Arquera',          900,  92, 10.5, 'https://static.wikia.nocookie.net/clashroyale/images/e/ef/SuperArchersCard.png/revision/latest'),   -- 26
('Super Gigante',         2800, 118, 36.0, 'https://static.wikia.nocookie.net/clashroyale/images/b/b1/GiantCard.png/revision/latest'),   -- 27
('Super Mini PEKKA',      1600, 106, 21.0, 'https://static.wikia.nocookie.net/clashroyale/images/b/b3/SuperMiniPEKKACard.png/revision/latest'),   -- 28
('Super Valkiria',        1800, 106, 24.0, 'https://static.wikia.nocookie.net/clashroyale/images/e/e2/ValkyrieCard.png/revision/latest'),   -- 29
('Super PEKKA',           3200, 120, 40.0, 'https://static.wikia.nocookie.net/clashroyale/images/f/fe/PEKKACard.png/revision/latest'),   -- 30
('Electro Dragón',        1500, 112, 20.0, 'https://static.wikia.nocookie.net/clashroyale/images/8/8a/ElectroDragonCard.png/revision/latest'),   -- 31
('Electro Gigante',       2300, 113, 31.0, 'https://static.wikia.nocookie.net/clashroyale/images/0/08/ElectroGiantCard.png/revision/latest'),   -- 32
('Electro Espíritu',       250,  80,  3.5, 'https://static.wikia.nocookie.net/clashroyale/images/7/70/ElectroSpiritCard.png/revision/latest'),   -- 33
('Oso Garra',             1800, 110, 25.0, 'https://static.wikia.nocookie.net/clashroyale/images/9/9e/RascalsCard.png/revision/latest'),   -- 34
('Campeon',               1600, 108, 22.0, 'https://static.wikia.nocookie.net/clashroyale/images/0/04/GoldenKnightCard.png/revision/latest'),   -- 35
('Rey Bárbaro',           3000, 120, 38.0, 'https://static.wikia.nocookie.net/clashroyale/images/d/d3/SkeletonKingCard.png/revision/latest'),   -- 36
('Reina Arquera',         1200, 115, 16.0, 'https://static.wikia.nocookie.net/clashroyale/images/2/24/PrincessCard.png/revision/latest'),   -- 37
('Gran Guardián',         3500, 125, 42.0, 'https://static.wikia.nocookie.net/clashroyale/images/5/5d/MonkCard.png/revision/latest'),   -- 38
('Rey Real',              3200, 122, 40.0, 'https://static.wikia.nocookie.net/clashroyale/images/0/0b/MegaKnightCard.png/revision/latest'),   -- 39
('Constructor',            800,  90, 10.0, 'https://static.wikia.nocookie.net/clashroyale/images/4/44/GoblinGiantCard.png/revision/latest'),   -- 40
('Goblin Constructor',     400,  78,  5.5, 'https://static.wikia.nocookie.net/clashroyale/images/b/bd/GoblinsCard.png/revision/latest'),   -- 41
('Bárbaro Barril',        1000,  95, 14.0, 'https://static.wikia.nocookie.net/clashroyale/images/b/b5/BarbarianBarrelCard.png/revision/latest'),   -- 42
('Jinete Cerdo',          1150,  98, 15.5, 'https://static.wikia.nocookie.net/clashroyale/images/3/30/HogRiderCard.png/revision/latest'),   -- 43
('Bruja Oscura',          1000, 122, 13.0, 'https://static.wikia.nocookie.net/clashroyale/images/7/7f/NightWitchCard.png/revision/latest'),   -- 44
('Gigante Lechero',       1900, 109, 27.0, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaRNOIbTDhTxrMnYuBgqys_mOywvgPnlTBiulxTcEnUw&s=10'),   -- 45
('Mago Real',              900, 115, 12.0, 'https://static.wikia.nocookie.net/clashroyale/images/c/cb/MagicArcherCard.png/revision/latest'),   -- 46
('Guardia Esqueleto',      350,  72,  4.5, 'https://static.wikia.nocookie.net/clashroyale/images/d/d0/SkeletonArmyCard.png/revision/latest'),   -- 47
('Pirata Goblin',          600,  82,  8.0, 'https://static.wikia.nocookie.net/clashroyale/images/7/70/DartGoblinCard.png/revision/latest'),   -- 48
('Sabueso de Lava',       3000, 118, 38.0, 'https://static.wikia.nocookie.net/clashroyale/images/d/de/LavaHoundCard.png/revision/latest'),   -- 49
('Dragón Infernal',       2400, 116, 33.0, 'https://static.wikia.nocookie.net/clashroyale/images/9/95/InfernoDragonCard.png/revision/latest');   -- 50

-- ------------------------------------------------------------
-- Relaciones peleador_arma (2-3 armas por peleador)
-- ------------------------------------------------------------

INSERT INTO peleador_arma (peleador_id, arma_id) VALUES
(1, 1),(1, 21),           -- Príncipe
(2, 5),(2, 37),           -- Arquera
(3, 4),(3, 22),(3, 40),   -- Gigante
(4, 9),(4, 17),           -- Príncipe Oscuro
(5, 8),(5, 29),           -- Espadachín
(6, 2),(6, 34),           -- Caballero
(7, 23),(7, 47),          -- Mini PEKKA
(8, 24),(8, 48),          -- Valkiria
(9, 13),(9, 38),(9, 44),  -- PEKKA
(10,25),(10,43),          -- Bebé Dragón
(11,6),(11,30),           -- Mosquetero
(12,35),(12,49),          -- Bruja
(13,22),(13,46),(13,40),  -- Gigante de Piedra
(14,18),(14,39),          -- Leñador
(15,7),(15,31),           -- Minero
(16,26),(16,38),(16,16),  -- Gigante Eléctrico
(17,32),(17,19),          -- Bruja de Hielo
(18,10),(18,3),           -- Bárbaro
(19,29),(19,42),          -- Esqueleto
(20,6),(20,36),           -- Goblin
(21,25),(21,30),          -- Drag Baby
(22,19),(22,34),          -- Caballero de Hielo
(23,27),(23,37),          -- Cazador Real
(24,34),(24,2),           -- Guardia Real
(25,44),(25,10),(25,3),   -- Super Bárbaro
(26,45),(26,5),           -- Super Arquera
(27,46),(27,22),(27,4),   -- Super Gigante
(28,47),(28,23),          -- Super Mini PEKKA
(29,48),(29,24),(29,33),  -- Super Valkiria
(30,13),(30,44),(30,38),  -- Super PEKKA
(31,43),(31,26),          -- Electro Dragón
(32,38),(32,26),(32,16),  -- Electro Gigante
(33,20),(33,29),          -- Electro Espíritu
(34,33),(34,40),          -- Oso Garra
(35,21),(35,9),           -- Campeon
(36,11),(36,44),(36,50),  -- Rey Bárbaro
(37,12),(37,45),          -- Reina Arquera
(38,11),(38,46),(38,4),   -- Gran Guardián
(39,11),(39,21),(39,38),  -- Rey Real
(40,31),(40,7),           -- Constructor
(41,6),(41,31),           -- Goblin Constructor
(42,28),(42,3),           -- Bárbaro Barril
(43,2),(43,34),           -- Jinete Cerdo
(44,35),(44,49),          -- Bruja Oscura
(45,40),(45,22),(45,4),   -- Gigante Lechero
(46,49),(46,32),          -- Mago Real
(47,42),(47,29),          -- Guardia Esqueleto
(48,36),(48,27),          -- Pirata Goblin
(49,43),(49,26),(49,13),  -- Sabueso de Lava
(50,43),(50,13),(50,25);  -- Dragón Infernal

-- ------------------------------------------------------------
-- Relaciones peleador_ataque (2-3 ataques por peleador)
-- ------------------------------------------------------------

INSERT INTO peleador_ataque (peleador_id, ataque_id) VALUES
(1, 1),(1, 40),           -- Príncipe
(2, 2),(2, 38),           -- Arquera
(3, 3),(3, 47),(3, 15),   -- Gigante
(4, 13),(4, 28),          -- Príncipe Oscuro
(5, 9),(5, 48),           -- Espadachín
(6, 5),(6, 43),           -- Caballero
(7, 8),(7, 28),           -- Mini PEKKA
(8, 17),(8, 46),          -- Valkiria
(9, 8),(9, 28),(9, 49),   -- PEKKA
(10,6),(10,33),           -- Bebé Dragón
(11,21),(11,38),          -- Mosquetero
(12,7),(12,27),(12,45),   -- Bruja
(13,47),(13,3),(13,32),   -- Gigante de Piedra
(14,18),(14,30),          -- Leñador
(15,22),(15,39),          -- Minero
(16,25),(16,20),(16,44),  -- Gigante Eléctrico
(17,12),(17,35),(17,10),  -- Bruja de Hielo
(18,5),(18,9),            -- Bárbaro
(19,48),(19,27),          -- Esqueleto
(20,4),(20,19),           -- Goblin
(21,33),(21,6),           -- Drag Baby
(22,43),(22,10),          -- Caballero de Hielo
(23,34),(23,21),          -- Cazador Real
(24,43),(24,2),           -- Guardia Real
(25,23),(25,5),(25,30),   -- Super Bárbaro
(26,2),(26,38),           -- Super Arquera
(27,3),(27,47),(27,49),   -- Super Gigante
(28,8),(28,28),           -- Super Mini PEKKA
(29,17),(29,46),(29,40),  -- Super Valkiria
(30,49),(30,28),(30,8),   -- Super PEKKA
(31,24),(31,20),          -- Electro Dragón
(32,25),(32,20),(32,44),  -- Electro Gigante
(33,36),(33,16),          -- Electro Espíritu
(34,41),(34,47),          -- Oso Garra
(35,37),(35,40),          -- Campeon
(36,30),(36,5),(36,47),   -- Rey Bárbaro
(37,11),(37,31),          -- Reina Arquera
(38,30),(38,47),(38,49),  -- Gran Guardián
(39,30),(39,37),(39,40),  -- Rey Real
(40,32),(40,39),          -- Constructor
(41,4),(41,42),           -- Goblin Constructor
(42,19),(42,9),           -- Bárbaro Barril
(43,9),(43,5),            -- Jinete Cerdo
(44,45),(44,7),(44,27),   -- Bruja Oscura
(45,3),(45,47),(45,32),   -- Gigante Lechero
(46,35),(46,50),(46,14),  -- Mago Real
(47,48),(47,27),          -- Guardia Esqueleto
(48,4),(48,26),           -- Pirata Goblin
(49,6),(49,24),(49,14),   -- Sabueso de Lava
(50,6),(50,24),(50,49);   -- Dragón Infernal
