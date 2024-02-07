CREATE TABLE filme (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    tipo VARCHAR(55),
    duration VARCHAR(100),
    categoria VARCHAR(100),
    data_estreia DATE,
    image TEXT
);

