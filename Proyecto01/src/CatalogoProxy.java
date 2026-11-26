package tienda;

/**
 * Proxy de seguridad para el catalogo real.
 * Controla el acceso al CatalogoReal verificando los permisos antes de cargarlo.
 */
public class CatalogoProxy implements ICatalogo {

    /** Referencia al catalogo real */
    private CatalogoReal catalogoReal;

    /**
     * Constructor del proxy. El catalogo real no se carga hasta que sea necesario.
     */
    public CatalogoProxy() {
        this.catalogoReal = null;
    }

    /**
     * Verifica los permisos de acceso al catalogo.
     *
     * @return true siempre que el usuario tenga sesion su iniciada.
     */
    private boolean verificarAcceso() {
        // En una implementacion real, aqui se verifica el token del usuario.
        // En este caso, asumimos que si hay sesion, hay acceso.
        return true;
    }

    /**
     * Obtiene el catalogo. Carga el CatalogoReal solo si tiene acceso.
     *
     * @return El componente raiz del catalogo, o null si no tiene acceso.
     */
    @Override
    public ComponenteCatalogo obtenerCatalogo() {
        if (verificarAcceso()) {
            if (catalogoReal == null) {
                System.out.println("Cargando catalogo desde el servidor remoto...");
                this.catalogoReal = new CatalogoReal();
            }
            return catalogoReal.obtenerCatalogo();
        } else {
            System.out.println("Acceso denegado al catalogo.");
            return null;
        }
    }

    /**
     * Busca un producto por codigo de barras. Reenvia la peticion al CatalogoReal si tiene acceso.
     *
     * @param codigoBarras El codigo de barras a buscar.
     * @return El producto, o null si no existe o no hay acceso.
     */
    @Override
    public Producto buscarProducto(String codigoBarras) {
        if (verificarAcceso()) {
            if (catalogoReal == null) {
                System.out.println("Cargando catalogo desde el servidor remoto...");
                this.catalogoReal = new CatalogoReal();
            }
            return catalogoReal.buscarProducto(codigoBarras);
        }
        return null;
    }
}