INSERT INTO pizzas (id, price, description, image, name ) VALUES (1, '5.50', 'mozzarella-pomodoro-basilico-olio EVO','https://cdn.pixabay.com/photo/2020/06/08/16/49/pizza-5275191_1280.jpg', 'Margherita'), (2, '6.50', 'pomodoro-mozzarella-acciughe-olio EVO', 'https://cdn.pixabay.com/photo/2015/07/24/06/08/pizza-857884_1280.jpg', 'Marinara'), (3, '7.50', 'mozzarella-gorgonzola-edamer-squacquerone', 'https://cdn.pixabay.com/photo/2020/06/17/21/46/pizza-5311269_1280.jpg', 'Quattro Formaggi'), (4, '7.50', 'pomodoro-mozzarella-speck-mascarpone', 'https://cdn.pixabay.com/photo/2021/09/02/13/10/tarte-flambee-6593419_1280.jpg', 'Speck e mascarpone'), (5, '4.50', 'pomodoro-mozzarella-verdure di stagione', 'https://cdn.pixabay.com/photo/2014/05/18/11/25/pizza-346985_1280.jpg', 'Vegetariana'), (6, '6.50', 'pomodoro-mozzarella-salame piccante', 'https://cdn.pixabay.com/photo/2016/02/04/16/16/pizza-1179404_1280.jpg', 'Salame Piccante');
INSERT INTO offerts (id, pizza_id, when_end, when_start, offert_title) VALUES (1, 1, '2024-11-01', '2025-01-01', 'Sconto Speciale Fine Anno'), (2, 3, '2024-09-01', '2025-12-01', 'Sconto Invernale'), (3, 4, '2024-09-01', '2025-09-01', 'Sconto Annuale'), (4, 5, '2024-06-01', '2025-12-01', 'Sconto Speciale Veg'), (5, 5, '2024-06-01', '2025-10-01', 'Sconto Verdure di Stagione');
INSERT INTO ingredients (id, name, description, image, price) VALUES (1, 'Pomodori ciliegini', 'Pomodorini fresci tagliati al momento', 'pippirippi', '1.20'), (2, 'Gorgonzola', 'Gorgonozola DOP piccante', 'pippiripppippi', '2.00'), (3, 'Pancetta', 'Pancetta IGP affettata al momento', 'pimpirulin', '1.50'); 