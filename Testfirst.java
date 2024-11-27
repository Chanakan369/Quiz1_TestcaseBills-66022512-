import static org.junit.Assert.*;
import org.junit.Test;

public class Testfirst {

    // ทดสอบคำนวณค่าน้ำ
    @Test
    public void testCalculateWaterBill() {
        first.currentWaterMeter = 100;
        first.lastWaterMeter = 50;
        int expectedWaterBill = 250;  // (100 - 50) * 5 = 250
        assertEquals(expectedWaterBill, first.calculateWaterBill());
    }

    // ทดสอบคำนวณค่าไฟ
    @Test
    public void testCalculateElectBill() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        int expectedElectBill = 180;  // (50 - 20) * 6 = 180
        assertEquals(expectedElectBill, first.calculateElectBill());
    }

    // ทดสอบคำนวณบิลรวม (ห้องคู่)
    @Test
    public void testCalculateResultBillDouble() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        first.currentWaterMeter = 100;
        first.lastWaterMeter = 50;
        int expectedResult = 2430;  // (2000 + 180 + 250)
        assertEquals(expectedResult, first.calculateResultBill("D"));
    }

    // ทดสอบคำนวณบิลรวม (ห้องเดี่ยว)
    @Test
    public void testCalculateResultBillSingle() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        first.currentWaterMeter = 100;
        first.lastWaterMeter = 50;
        int expectedResult = 1930;  // (1500 + 180 + 250)
        assertEquals(expectedResult, first.calculateResultBill("S"));
    }

    // ทดสอบบิลเมื่อมิเตอร์น้ำมากกว่ามิเตอร์ก่อนหน้า
    @Test
    public void testCalculateWaterBillInvalid() {
        first.currentWaterMeter = 50;
        first.lastWaterMeter = 100;
        int expectedWaterBill = 0;  // ค่าไม่ถูกต้อง น้ำปัจจุบันน้อยกว่ามิเตอร์ก่อนหน้า
        assertEquals(expectedWaterBill, first.calculateWaterBill());
    }

    // ทดสอบบิลเมื่อมิเตอร์ไฟมากกว่ามิเตอร์ก่อนหน้า
    @Test
    public void testCalculateElectBillInvalid() {
        first.currentElectMeter = 20;
        first.lastElectMeter = 50;
        int expectedElectBill = 0;  // ค่าไม่ถูกต้อง ไฟฟ้าปัจจุบันน้อยกว่ามิเตอร์ก่อนหน้า
        assertEquals(expectedElectBill, first.calculateElectBill());
    }

    // ทดสอบประเภทห้องที่ไม่ได้เลือก (Invalid room type)
    @Test
    public void testInvalidRoomType() {
        first.currentElectMeter = 50;
        first.lastElectMeter = 20;
        first.currentWaterMeter = 100;
        first.lastWaterMeter = 50;
        int expectedResult = 0;  // ไม่เลือกห้อง
        assertEquals(expectedResult, first.calculateResultBill("X"));
    }
}

