import com.opencsv.CSVReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;


public class Main {

    //method to set date in the image
    public static void set_date(Graphics g,String date){
        String text2 = date;
        g.setFont(new Font("Regular", Font.PLAIN, 56)); //text font and size
        g.setColor(Color.getHSBColor(0.63F, 0.12F, 0.66F)); //text colour
        g.drawString(text2, 180, 472); //text coordinates on image
    }

    //method to get greetings as per time
    public static String get_greeting(){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get( Calendar.HOUR_OF_DAY );
        int month = cal.get( Calendar.MONTH );

        if( hour == 5 ) {
            if( month > 2 && month < 9 ) {
                return "Good Morning";
            }
            else {
                return "Good Night";
            }
        }
        else if( hour > 5 && hour < 12 ) {
            return "Good Morning";
        }
        else if( hour > 11 && hour < 17 ) {
            return "Good Afternoon";
        }
        else if( hour == 17 ) {
            if( month > 2 && month < 9 ) {
                return "Good Afternoon";
            }
            else {
                return "Good Evening";
            }
        }
        else if( hour > 17 && hour < 19 ) {
            return "Good Evening";
        }
        else {
            return "Good Night";
        }
    }

    //method to set greetings in image
    public static void set_greeting(Graphics g,String greeting){
        String text = greeting;
        g.setFont(new Font("Regular", Font.PLAIN, 56)); //text font and size
        g.setColor(Color.getHSBColor((float) 0.62, 0.25F, (float) 0.33)); //text colour
        g.drawString(text, 180, 270); //text coordinates on image
    }

    //method to set name in image
    static void set_name(Graphics g,String name) throws IOException {

        String text1 = name;
        g.setFont(new Font("Aeonik", Font.BOLD, 88)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text1, 180, 380); //text coordinates on image

    }

    //method to set account balance value in image
    public static void set_account_balance(Graphics g,String acc_balance){
        String text1 = acc_balance;
        g.setFont(new Font("Aeonik", Font.BOLD, 136)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text1, 1200, 790); //text coordinates on image
    }

    //method to set yesterday spent value in image
    public static void set_yesterday_spent(Graphics g,String yesterday_spend){
        String text1 = yesterday_spend;
        g.setFont(new Font("Aeonik", Font.BOLD, 120)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text1, 1304, 1185); //text coordinates on image
    }

    //method to set top send value in image
    public static void set_top_spend(Graphics g,String top_s_1,String top_s_2,String top_s_3){
        //top 1 spend
        String text1 = top_s_1;
        g.setFont(new Font("Aeonik", Font.BOLD, 56)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text1, 1380, 1520); //text coordinates on image

        //top 2 spend
        String text2 = top_s_2;
        g.setFont(new Font("Aeonik", Font.BOLD, 56)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text2, 1380, 1628); //text coordinates on image

        //top 3 spend
        String text3 = top_s_3;
        g.setFont(new Font("Aeonik", Font.BOLD, 56)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text3, 1380, 1736); //text coordinates on image
    }

    //method to set outstanding bills value in image
    public static void set_out_standing_bills(Graphics g,String outstanding){
        String text1 = outstanding;
        g.setFont(new Font("Aeonik", Font.BOLD, 120)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text1, 1280, 2150); //text coordinates on image
    }

    //method to set budgeted value in image
    public static void set_budgeted(Graphics g,String budget){
        String text1 = budget;
        g.setFont(new Font("Aeonik", Font.BOLD, 80)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text1, 548, 2744); //text coordinates on image
    }

    //method to set actual value in image
    public static void set_actual(Graphics g,String actual){
        String text1 = actual;
        g.setFont(new Font("Aeonik", Font.BOLD, 80)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text1, 1064, 2744); //text coordinates on image
    }

    //method to set account's numbers in image
    public static void set_accounts_number(Graphics g,String acc_nums){
        //account's number under account balance
        String text1 = acc_nums;
        g.setFont(new Font("Regular", Font.PLAIN, 48)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text1, 200, 805); //text coordinates on image

        //account's number under outstanding bills
        g.setFont(new Font("Regular", Font.PLAIN, 48)); //text font and size
        g.setColor(Color.getHSBColor(0.62F, 0.25F, 0.33F)); //text colour
        g.drawString(text1, 240, 2165); //text coordinates on image

    }

    //method to get date in image
    public static String get_date(){
        String rev_date = String.valueOf(LocalDateTime.now());
        String[] ele_arr = rev_date.split("-");
        String year = ele_arr[0];
        String month = ele_arr[1];
        String date = ele_arr[2].substring(0,2);
        String ans = date+"-"+month+"-"+year;
        return ans;
    }

    //method to get the data which needs to be places in image from csv file
    public static ArrayList<String[]> get_csv_data() throws FileNotFoundException {

        try {
            //path for csv file
            String file = "C:\\Users\\HP\\OneDrive\\Desktop\\Mydhan\\transactional img\\transactional_img_gen\\Transactional_img_generator\\src\\main\\resources\\data.csv";

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            ArrayList<String[]> data = new ArrayList<>();
            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                data.add(nextRecord);
            }
            return data;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    //method to write the data which we read from csv to image
    public static void write_all_data_to_img(ArrayList<String[]> arr,String path) throws IOException {


        int id = 0;
        for(int i=1;i<arr.size();i++){

            //path of the image on which we have to write the data
            BufferedImage image = ImageIO.read(new File("C:\\Users\\HP\\OneDrive\\Desktop\\Mydhan\\transactional img\\transactional_img_gen\\Transactional_img_generator\\src\\main\\resources\\Group 2561 (1).png"));
            Graphics g = image.getGraphics();


            String data[]  = arr.get(i);
            id++;
            String name = data[0];

            String acc_balance = data[1];
            String total_account = data[2];
            String yesterday_spend = data[3];
            String top_1_spend= data[4];
            String top_2_spend= data[5];
            String top_3_spend= data[6];
            String out_standing = data[7];
            String budget = data[8];
            String actual = data[9];


            String date = get_date();
            String greeting = get_greeting();
            set_greeting(g,greeting);
            set_name(g,name);
            set_date(g,date);
            set_account_balance(g,acc_balance);
            set_yesterday_spent(g,yesterday_spend);
            set_top_spend(g,top_1_spend,top_2_spend,top_3_spend);
            set_out_standing_bills(g,out_standing);
            set_budgeted(g,budget);
            set_actual(g,actual);
            set_accounts_number(g,total_account);

            ImageIO.write(image, "png", new File(path+id+".jpg"));
            g.dispose();
        }

    }

    //main method
    public static void  main(String[] args) throws IOException {

        //path where the output images would be generated
        String full_path = "C:\\Users\\HP\\OneDrive\\Desktop\\output.jpg\\";
        File f=new File(full_path);
        f.mkdir();

        ArrayList<String[]> all_data = get_csv_data();
        write_all_data_to_img(all_data,full_path);

    }
}