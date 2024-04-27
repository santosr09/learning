INSERT INTO marca (id, descripcion, status) VALUES(1, 'GAMESA', 0);
INSERT INTO marca (id, descripcion, status) VALUES(2, 'SAN MARCOS', 0);
INSERT INTO marca (id, descripcion, status) VALUES(3, 'ALPURA', 0);
INSERT INTO marca (id, descripcion, status) VALUES(4, 'P&G', 0);
INSERT INTO marca (id, descripcion, status) VALUES(5, 'COCA-COLA', 0);
INSERT INTO marca (id, descripcion, status) VALUES(6, 'LALA', 0);
INSERT INTO marca (id, descripcion, status) VALUES(7, 'FUD', 0);
INSERT INTO marca (id, descripcion, status) VALUES(8, 'PALMOLIVE', 0);

INSERT INTO categoria (id, descripcion, status) VALUES(0, 'SIN DEFINIR', 0);
INSERT INTO marca (id, descripcion, status) VALUES(0, 'SIN DEFINIR', 0);

INSERT INTO cat_presentacion (id, nombre, unidades_contenidas, factor_conversion, status)
VALUES(1, 'PIEZA', 1.0, 1.0, 0);

INSERT INTO cat_presentacion (id, nombre, unidades_contenidas, factor_conversion, status)
VALUES(2, 'METRO', 1.0, 1.0, 0);

INSERT INTO cat_presentacion (id, nombre, unidades_contenidas, factor_conversion, status)
VALUES(3, 'KILO', 1.0, 1.0, 0);

INSERT INTO producto (id, clave, clave_alterna,  id_marca, descripcion, status)
VALUES(1, '97339000054', '97339000054', 1, 'DOWNY LIBRE ENJUAGE TANGO 850 ML', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status)
VALUES(2, '7501001155841', '7501001155841', 0, 'DOWNY LIBRE ENJUAGUE 800 ML FLORAL', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status)
VALUES(3, '7501025413002', '7501025413002', 0, 'ENSUEÑO MAX PRIMAVERAL 850 ML', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status)
VALUES(4, '7501025413002', '7501025413002', 0, 'SUAVITEL PRIMAVERA 850 ML', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status)
VALUES(5, '7501052475004', '7501052475004', 0, 'VINAGRE BLANCO CLEMENTE 500 ML', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status)
VALUES(6, '7501060500019', '7501060500019', 0, 'ACEITE PATRONA  1 LT', 0);

INSERT INTO producto_almacen (id, id_producto, existencia_maxima, existencia_minima,
	existencia_virtual, existencia, precio_compra_ultimo, precio_compra_promedio, precio_venta_minimo,
	precio_venta_calculado, precio_venta, presentacion)
	VALUES(2, 2, 50, 8,
		20, 20, 10, 10.5, 9,
		12.6, 12.5, 'PIEZA');

INSERT INTO producto_almacen (id, id_producto, existencia_maxima, existencia_minima,
	existencia_virtual, existencia, precio_compra_ultimo, precio_compra_promedio, precio_venta_minimo,
	precio_venta_calculado, precio_venta, presentacion)
	VALUES(3, 3, 50, 8,
		14, 14, 11, 11.5, 10,
		13.6, 13.7, 'PIEZA');

