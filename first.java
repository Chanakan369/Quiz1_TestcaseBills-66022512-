public class first {
    public static int waterM, ElectM;
    public static int resultBill;
    public static int currentWaterMeter, lastWaterMeter;
    public static int currentElectMeter, lastElectMeter;

    // คำนวณค่าน้ำ
    public static int calculateWaterBill() {
        if (currentWaterMeter >= lastWaterMeter) {
            waterM = (currentWaterMeter - lastWaterMeter) * 5;
        } else {
            waterM = 0; // ค่ามิเตอร์ปัจจุบันน้อยกว่ามิเตอร์ก่อนหน้า
        }
        return waterM;
    }

    // คำนวณค่าไฟ
    public static int calculateElectBill() {
        if (currentElectMeter >= lastElectMeter) {
            ElectM = (currentElectMeter - lastElectMeter) * 6;
        } else {
            ElectM = 0; // ค่ามิเตอร์ปัจจุบันน้อยกว่ามิเตอร์ก่อนหน้า
        }
        return ElectM;
    }

    // คำนวณบิลทั้งหมดตามประเภทห้อง
    public static int calculateResultBill(String roomType) {
        int totalBill = calculateElectBill() + calculateWaterBill();
        if ("S".equals(roomType)) {
            totalBill += 1500; // ห้องเดี่ยว
        } else if ("D".equals(roomType)) {
            totalBill += 2000; // ห้องคู่
        } else {
            totalBill = 0; // ถ้าไม่เลือกห้อง
        }
        return totalBill;
    }

    public static void main(String[] args) {
        // กำหนดค่ามิเตอร์น้ำและไฟ
        currentElectMeter = 50;
        lastElectMeter = 20;
        currentWaterMeter = 100;
        lastWaterMeter = 50;

        // คำนวณและแสดงผลบิล
        System.out.println("Your bill is: " + calculateResultBill("D"));
    }
}
