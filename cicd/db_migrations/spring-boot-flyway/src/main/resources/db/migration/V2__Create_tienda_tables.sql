CREATE TABLE marca (
	id BIGINT NOT NULL PRIMARY KEY,
	descripcion   VARCHAR(100) NOT NULL,
	status  INTEGER
);

CREATE TABLE categoria (
	id BIGINT NOT NULL PRIMARY KEY,
	descripcion   VARCHAR(100) NOT NULL,
	status  INTEGER
);


CREATE TABLE cat_presentacion (
	id BIGINT NOT NULL PRIMARY KEY,
	nombre   VARCHAR(10) NOT NULL,
	unidades_contenidas DECIMAL(2,1),
	factor_conversion DECIMAL(2,1),
	status  INTEGER
);

CREATE TABLE producto (
	id BIGINT NOT NULL PRIMARY KEY,
	clave   VARCHAR(50) NOT NULL,
	clave_alterna   VARCHAR(50),
	id_categoria BIGINT REFERENCES categoria(id),
	id_marca BIGINT REFERENCES marca(id),
	descripcion VARCHAR(100) NOT NULL,
	status INTEGER
);

CREATE TABLE producto_almacen (
	id BIGINT NOT NULL PRIMARY KEY,
	id_producto BIGINT REFERENCES producto(id),
	existencia_maxima DECIMAL(10,2),
	existencia_minima DECIMAL(10,2),
	existencia_virtual DECIMAL(10,2),
	existencia DECIMAL(10,2),
	precio_compra_ultimo DECIMAL(10,2),
	precio_compra_promedio DECIMAL(10,2),
	precio_venta_minimo DECIMAL(10,2),
	precio_venta_calculado DECIMAL(10,2),
	precio_venta DECIMAL(10,2),
	presentacion VARCHAR(50) NOT NULL
);

CREATE TABLE nota_venta (
	id SERIAL NOT NULL PRIMARY KEY,
	fecha_hora VARCHAR(25) NOT NULL,
	cliente VARCHAR(25),
	vendedor VARCHAR(25),
	total_articulos DECIMAL(5,2),
	monto_total DECIMAL(5,2),
	iva DECIMAL(5,2)
);

CREATE TABLE proveedor (
	id BIGINT NOT NULL PRIMARY KEY,
	nombre   VARCHAR(50) NOT NULL,
	descripcion VARCHAR(100),
	direccion   VARCHAR(150),
	telefono1 VARCHAR(10),
	telefono2 VARCHAR(10),
	email VARCHAR(100),
	status INTEGER
);

CREATE TABLE nota_compra (
	id SERIAL NOT NULL PRIMARY KEY,
	id_proveedor BIGINT REFERENCES proveedor(id),
	fecha_hora VARCHAR(25) NOT NULL,
	total_articulos DECIMAL(5,2),
	monto_total DECIMAL(5,2),
	iva DECIMAL(5,2)
);

CREATE TABLE detalle_compra (
	id SERIAL NOT NULL PRIMARY KEY,
	id_nota_compra BIGINT REFERENCES nota_compra(id),
	id_producto BIGINT REFERENCES producto(id),
	id_presentacion_compra BIGINT REFERENCES cat_presentacion(id),
	unidades DECIMAL(5,2),
	monto_total DECIMAL(5,2),
	iva DECIMAL(5,2)
);

CREATE TABLE detalle_venta (
	id SERIAL NOT NULL PRIMARY KEY,
	id_nota_venta BIGINT REFERENCES nota_compra(id),
	id_producto BIGINT REFERENCES producto(id),
	unidades DECIMAL(5,2),
	monto_total DECIMAL(5,2)
);


ALTER TABLE public.nota_venta ADD COLUMN id_detalle bigint;

ALTER TABLE public.producto_almacen ADD COLUMN id_presentacion_venta bigint;

ALTER TABLE public.producto_almacen ADD COLUMN id_presentacion_compra bigint;


ALTER TABLE public.producto_almacen ADD CONSTRAINT producto_id_presentacion_venta_fkey FOREIGN KEY (id_presentacion_venta)
      REFERENCES public.cat_presentacion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE public.producto_almacen ADD CONSTRAINT producto_id_presentacion_compra_fkey FOREIGN KEY (id_presentacion_compra)
      REFERENCES public.cat_presentacion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

--ALTER TABLE public.producto ADD CONSTRAINT producto_id_marca_fkey FOREIGN KEY (id_marca)



