public class TestDependencyInjection {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into CustomerService 
        CustomerService customerService = new CustomerService(customerRepository);

        customerService.printCustomer(1);
    }
}