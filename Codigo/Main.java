import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ShipmentManager manager = ShipmentManager.getInstance();

        ShipmentSubject subject = new ShipmentSubject();

        subject.addObserver(new CustomerObserver());
        subject.addObserver(new WarehouseObserver());
        subject.addObserver(new BillingObserver());

        boolean salir = false;

        while (!salir) {

            System.out.println("\n===== SISTEMA DE ENVÍOS =====");
            System.out.println("1. Crear envío");
            System.out.println("2. Asignar repartidor");
            System.out.println("3. Cambiar estado del envío");
            System.out.println("4. Cancelar envío");
            System.out.println("5. Calcular costo");
            System.out.println("6. Listar todos los envíos");
            System.out.println("7. Recorrer envíos con Iterator");
            System.out.println("8. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("ID del envío:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Cliente:");
                    String cliente = sc.nextLine();

                    System.out.println("Dirección:");
                    String direccion = sc.nextLine();

                    Envio envio = new Envio(id, cliente, direccion);

                    Command crear = new CreateShipmentCommand(manager, envio);
                    crear.ejecutar();

                    subject.notifyObservers(envio);

                    System.out.println("Envío creado.");

                    break;

                case 2:

                    System.out.println("ID del envío:");
                    int idEnvio = sc.nextInt();
                    sc.nextLine();

                    Envio envioAsignar = manager.buscarEnvio(idEnvio);

                    if (envioAsignar != null) {

                        System.out.println("ID repartidor:");
                        int idRep = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Nombre repartidor:");
                        String nombreRep = sc.nextLine();

                        Repartidor r = new Repartidor(idRep, nombreRep);

                        Command asignar = new AssignDriverCommand(envioAsignar, r);
                        asignar.ejecutar();

                        subject.notifyObservers(envioAsignar);

                        System.out.println("Repartidor asignado.");
                    } else {
                        System.out.println("Envío no encontrado.");
                    }

                    break;

                case 3:

                    System.out.println("ID del envío:");
                    int idEstado = sc.nextInt();
                    sc.nextLine();

                    Envio envioEstado = manager.buscarEnvio(idEstado);

                    if (envioEstado != null) {

                        System.out.println("1.EN_RUTA  2.ENTREGADO");

                        int est = sc.nextInt();

                        EstadoEnvio nuevoEstado;

                        if (est == 1) {
                            nuevoEstado = EstadoEnvio.enRuta;
                        } else {
                            nuevoEstado = EstadoEnvio.entregado;
                        }

                        Command cambiarEstado = new UpdateShipmentStatusCommand(envioEstado, nuevoEstado);
                        cambiarEstado.ejecutar();

                        subject.notifyObservers(envioEstado);

                        System.out.println("Estado actualizado.");
                    }

                    break;

                case 4:

                    System.out.println("ID del envío:");
                    int idCancel = sc.nextInt();

                    Envio envioCancel = manager.buscarEnvio(idCancel);

                    if (envioCancel != null) {

                        Command cancelar = new CancelShipmentCommand(envioCancel);
                        cancelar.ejecutar();

                        subject.notifyObservers(envioCancel);

                        System.out.println("Envío cancelado.");
                    }

                    break;

                case 5:

                    System.out.println("ID del envío:");
                    int idCosto = sc.nextInt();

                    Envio envioCosto = manager.buscarEnvio(idCosto);

                    if (envioCosto != null) {

                        System.out.println("Tipo de envío:");
                        System.out.println("1. Standard");
                        System.out.println("2. Express");
                        System.out.println("3. International");

                        int tipo = sc.nextInt();

                        if (tipo == 1) {
                            envioCosto.setStrategy(new StandardShippingStrategy());
                        } 
                        else if (tipo == 2) {
                            envioCosto.setStrategy(new ExpressShippingStrategy());
                        } 
                        else {
                            envioCosto.setStrategy(new InternationalShippingStrategy());
                        }

                        double costo = envioCosto.calcularCosto();

                        System.out.println("Costo del envío: " + costo);
                    }

                    break;

                case 6:

                    for (Envio e : manager.listarEnvios()) {

                        System.out.println(
                                "ID: " + e.getId() +
                                " Cliente: " + e.getCliente() +
                                " Estado: " + e.getEstado()
                        );
                    }

                    break;

                case 7:

                    ShipmentIterator it = manager.crearIterador();

                    while (it.hasNext()) {

                        Envio e = it.next();

                        System.out.println(
                                "ID: " + e.getId() +
                                " Cliente: " + e.getCliente() +
                                " Estado: " + e.getEstado()
                        );
                    }

                    break;

                case 8:

                    salir = true;
                    System.out.println("Saliendo del sistema...");

                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }

        sc.close();
    }
}