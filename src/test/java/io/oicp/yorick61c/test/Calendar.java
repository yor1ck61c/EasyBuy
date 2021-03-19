package io.oicp.yorick61c.test;

        import java.util.Scanner;

public class Calendar {

    private int year;

    private int month;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public Calendar(int year, int month) {

        this.year = year;

        this.month = month;

    }

    public static boolean isLeapYear(int year){

        return year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0));
    }

    public static int getNumberOfDaysInMonth(int year, int month){

        if(month == 4 || month == 6 || month == 9 || month == 11){

            return 30;

        }else if (month == 2){

            return isLeapYear(year) ? 29 : 28;

        }else{

            return 31;

        }

    }

    public static int getTotalNumberOfDays(int year, int month){

        int total = 0;

        for(int i = 1800 ; i < year ; i++){

            if (isLeapYear(i)){

                total += 366;

            }else{

                total += 365;

            }

        }

        for(int i = 1 ; i < month ; i++ ){

            total += getNumberOfDaysInMonth(year,i);

        }

        return total;

    }

    public static String getMonthName(int month){

        String monthName = null;

        switch(month){
            case 1:monthName = "January";break;
            case 2:monthName = "February";break;
            case 3:monthName = "March";break;
            case 4:monthName = "April";break;
            case 5:monthName = "May	";break;
            case 6:monthName = "June";break;
            case 7:monthName = "July";break;
            case 8:monthName = "August";break;
            case 9:monthName = "September";break;
            case 10:monthName = "October";break;
            case 11:monthName = "November";break;
            case 12:monthName = "December";break;
        }

        return monthName;

    }

    public static void printMonthTitle(int year, int month){

        System.out.println("       " + getMonthName(month) + "   " + year );

        System.out.println("-----------------------------");

        System.out.println("  Sun Mon Tue Wed Thu Fri Sat");

    }

    public static int getStartDay(int year, int month){

        final int startDay = 3;

        int totalNumberOfDays = getTotalNumberOfDays(year,month);

        return (totalNumberOfDays + startDay ) % 7 ;

    }

    public static String getEndDay(int year, int month){

        switch ((getStartDay(year, month) + getNumberOfDaysInMonth(year, month)) % 7){
            case 0: return "星期六";
            case 1: return "星期日";
            case 2: return "星期一";
            case 3: return "星期二";
            case 4: return "星期三";
            case 5: return "星期四";
            case 6: return "星期五";
            default: return null;
        }

    }

    public static void printMonthBody(int year , int month){

        int startDay = getStartDay(year,month);

        int numberOfDaysInMonth = getNumberOfDaysInMonth(year,month);

        int i;

        for (i = 0 ; i < startDay ; i++){

            System.out.print("    ");

        }

        for (i = 1 ; i <= numberOfDaysInMonth ; i++){

            System.out.printf("%4d", i);

            if((i + startDay)% 7 == 0){

                System.out.println();

            }

        }

        System.out.println();

    }

    public static void printMonth(int year, int month){

        printMonthTitle(year,month);

        printMonthBody(year,month);

    }

    public static void printPreviousMonth(int year, int month){

        if (month == 1){

            printMonthTitle(--year,12);

            printMonthBody(year,12);

        }else {

            printMonthTitle(year, --month);

            printMonthBody(year, month);

        }

    }

    public static void printNextMonth(int year, int month){

        if (month == 12){

            printMonthTitle(++year,1);

            printMonthBody(year,1);

        }else {

            printMonthTitle(year,++month);

            printMonthBody(year,month);

        }



    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter full year (e.g., 2012):");

        int year = input.nextInt();

        System.out.println("Enter month:");

        int month = input.nextInt();

        Calendar.printMonth(year,month);

        System.out.println();

        System.out.println();

        Calendar.printNextMonth(year, month);

        System.out.println();

        System.out.println();

        Calendar.printPreviousMonth(year, month);

        System.out.println();

        System.out.println(year + "年" + month + "月的最后一天是：" + Calendar.getEndDay(year, month));


    }

}