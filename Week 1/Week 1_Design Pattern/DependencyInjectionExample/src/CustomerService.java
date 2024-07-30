public class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomer(int id) {
        String customer = customerRepository.findCustomerById(id);
        System.out.println(customer);
    }
}
