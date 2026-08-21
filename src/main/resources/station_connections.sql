INSERT INTO station_connections
    (from_station_id, to_station_id)
VALUES
    (
        (SELECT id FROM stations WHERE name = 'Indiranagar'),
        (SELECT id FROM stations WHERE name = 'Swami Vivekananda Road')
    ),
    (
        (SELECT id FROM stations WHERE name = 'Swami Vivekananda Road'),
        (SELECT id FROM stations WHERE name = 'Halasuru')
    ),
    (
        (SELECT id FROM stations WHERE name = 'Halasuru'),
        (SELECT id FROM stations WHERE name = 'Trinity')
    ),
    (
        (SELECT id FROM stations WHERE name = 'Trinity'),
        (SELECT id FROM stations WHERE name = 'MG Road')
    ),
    (
        (SELECT id FROM stations WHERE name = 'MG Road'),
        (SELECT id FROM stations WHERE name = 'Cubbon Park')
    ),
    (
        (SELECT id FROM stations WHERE name = 'Cubbon Park'),
        (SELECT id FROM stations WHERE name = 'Vidhana Soudha')
    ),
    (
        (SELECT id FROM stations WHERE name = 'Vidhana Soudha'),
        (SELECT id FROM stations WHERE name = 'Sir M. Visveshwaraya')
    ),
    (
        (SELECT id FROM stations WHERE name = 'Sir M. Visveshwaraya'),
        (SELECT id FROM stations WHERE name = 'Majestic')
    );