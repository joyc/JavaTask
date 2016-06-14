package task4;

/**
 * Created by a5095153 on 2016/06/14.
 */

import java.util.Scanner;

public class AtmGetMoney {

    public static void main(String[] args) {
        String password = "111111";
        int count = 0;
        int a = 0;
        while(count<3){
            System.out.println("请输入银行卡密码： ");
            Scanner scan = new Scanner(System.in);
            String passwd = scan.nextLine();
            while(passwd.equals(password)){
                System.out.println("请输入取款金额： ");
                int amount = scan.nextInt();
                if(amount%100 == 0 && amount <= 1000){
                    System.out.println("您的取款金额为： "+amount);
                    System.out.println("交易完成，请读卡！");
                    a = a + 1;
                    break;
                }
                else {
                    System.out.println("只能提取100元纸币，要求最低0，最高1000！");
                    continue;
                }
            }
            if (a == 1){
                break;
            }
            else if (count < 2) {
                System.out.println("银行卡密码错误");
                count = count + 1;
                continue;
            }
            else {
                System.out.println("密码错误请读卡");
                break;
            }

        }

    }

}