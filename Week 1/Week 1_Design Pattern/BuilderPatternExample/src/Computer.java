public class Computer {
    private final String CPU;
    private final String RAM;
    private final String storage;
    private final String GPU;
    private final String motherboard;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.motherboard = builder.motherboard;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage +
               ", GPU=" + GPU + ", Motherboard=" + motherboard + "]";
    }

    public static class Builder {
        private final String CPU;
        private final String RAM;
        private String storage = "256GB SSD"; 
        private String GPU = "Integrated"; 
        private String motherboard = "Standard"; 

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
