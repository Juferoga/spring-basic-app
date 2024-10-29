-- Insertar datos de ejemplo en la tabla ingredient
INSERT INTO public.ingredient ("name") VALUES 
('Tomate'),
('Cebolla'),
('Ajo'),
('Pollo'),
('Sal'),
('Pimienta'),
('Zanahoria'),
('Papas'),
('Lechuga'),
('Queso');

-- Insertar datos de ejemplo en la tabla users
INSERT INTO public.users (user_type, email, "name", "password", username, user_id) VALUES 
('admin', 'admin@example.com', 'Usuario Admin', 'adminpass', 'adminuser', NULL),
('user', 'user1@example.com', 'Usuario Uno', 'user1pass', 'usuario1', NULL),
('user', 'user2@example.com', 'Usuario Dos', 'user2pass', 'usuario2', NULL),
('user', 'user3@example.com', 'Usuario Tres', 'user3pass', 'usuario3', NULL),
('user', 'user4@example.com', 'Usuario Cuatro', 'user4pass', 'usuario4', NULL),
('user', 'user5@example.com', 'Usuario Cinco', 'user5pass', 'usuario5', NULL),
('user', 'user6@example.com', 'Usuario Seis', 'user6pass', 'usuario6', NULL),
('user', 'user7@example.com', 'Usuario Siete', 'user7pass', 'usuario7', NULL),
('user', 'user8@example.com', 'Usuario Ocho', 'user8pass', 'usuario8', NULL),
('user', 'user9@example.com', 'Usuario Nueve', 'user9pass', 'usuario9', NULL);

-- Insertar datos de ejemplo en la tabla recipe
INSERT INTO public.recipe (description, image, "name", preparation, user_id) VALUES 
('Una deliciosa sopa de tomate', 'sopa_tomate.jpg', 'Sopa de Tomate', 'Hervir tomates y licuarlos', 2),
('Pollo a la parrilla con ajo', 'pollo_parrilla.jpg', 'Pollo a la Parrilla', 'Asar el pollo con ajo', 3),
('Ensalada fresca', 'ensalada_fresca.jpg', 'Ensalada Fresca', 'Mezclar lechuga, zanahoria y queso', 4),
('Papas fritas', 'papas_fritas.jpg', 'Papas Fritas', 'Freír las papas', 5),
('Quesadillas', 'quesadillas.jpg', 'Quesadillas', 'Calentar tortillas con queso', 6),
('Sopa de cebolla', 'sopa_cebolla.jpg', 'Sopa de Cebolla', 'Hervir cebollas y licuarlas', 7),
('Pollo al horno', 'pollo_horno.jpg', 'Pollo al Horno', 'Hornear el pollo', 8),
('Ensalada de pollo', 'ensalada_pollo.jpg', 'Ensalada de Pollo', 'Mezclar pollo con lechuga', 9),
('Sopa de zanahoria', 'sopa_zanahoria.jpg', 'Sopa de Zanahoria', 'Hervir zanahorias y licuarlas', 10),
('Tacos de pollo', 'tacos_pollo.jpg', 'Tacos de Pollo', 'Rellenar tortillas con pollo', 2);

-- Insertar datos de ejemplo en la tabla recipe_ingredient
INSERT INTO public.recipe_ingredient (recipe_id, ingredient_id) VALUES 
(1, 1), -- Sopa de Tomate con Tomate
(1, 2), -- Sopa de Tomate con Cebolla
(1, 5), -- Sopa de Tomate con Sal
(2, 4), -- Pollo a la Parrilla con Pollo
(2, 3), -- Pollo a la Parrilla con Ajo
(2, 6), -- Pollo a la Parrilla con Pimienta
(3, 8), -- Ensalada Fresca con Lechuga
(3, 7), -- Ensalada Fresca con Zanahoria
(3, 10), -- Ensalada Fresca con Queso
(4, 9), -- Papas Fritas con Papas
(5, 10), -- Quesadillas con Queso
(6, 2), -- Sopa de Cebolla con Cebolla
(7, 4), -- Pollo al Horno con Pollo
(8, 4), -- Ensalada de Pollo con Pollo
(8, 8), -- Ensalada de Pollo con Lechuga
(9, 7), -- Sopa de Zanahoria con Zanahoria
(10, 4), -- Tacos de Pollo con Pollo
(10, 2), -- Tacos de Pollo con Cebolla
(10, 3); -- Tacos de Pollo con Ajo

-- Insertar datos de ejemplo en la tabla commentaries
INSERT INTO public.commentaries ("comment", "date", recipe_id, user_id) VALUES 
('¡Esta sopa es increíble!', '2023-10-01 12:00:00', 1, 3),
('¡Me encantó el pollo a la parrilla!', '2023-10-02 14:30:00', 2, 2),
('La ensalada está muy fresca', '2023-10-03 10:15:00', 3, 4),
('Las papas fritas están crujientes', '2023-10-04 11:45:00', 4, 5),
('Las quesadillas están deliciosas', '2023-10-05 13:00:00', 5, 6),
('La sopa de cebolla es muy sabrosa', '2023-10-06 09:30:00', 6, 7),
('El pollo al horno está jugoso', '2023-10-07 15:00:00', 7, 8),
('La ensalada de pollo es muy nutritiva', '2023-10-08 16:45:00', 8, 9),
('La sopa de zanahoria es muy saludable', '2023-10-09 17:30:00', 9, 10),
('Los tacos de pollo están muy buenos', '2023-10-10 18:00:00', 10, 2);