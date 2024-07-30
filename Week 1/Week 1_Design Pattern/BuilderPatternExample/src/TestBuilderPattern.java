public class TestBuilderPattern {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA GeForce RTX 3080")
            .setMotherboard("ASUS ROG")
            .build();

        Computer officePC = new Computer.Builder("Intel i5", "16GB")
            .setStorage("512GB SSD")
            .build();

        Computer basicPC = new Computer.Builder("Intel i3", "8GB")
            .build();

        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
        System.out.println("Basic PC: " + basicPC);
    }
}
