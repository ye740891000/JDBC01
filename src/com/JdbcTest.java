import java.sql.*;

public class JdbcTest {
    //数据库连接地址
    private final static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    //用户名
    public final static String USERNAME = "root";
    //密码
    public final static String PASSWORD = "123456";
    //加载的驱动程序类
    public final static String DRIVER = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {

        //insert();
        //delete();
        //update();
        //select();

    }

    //方法：插入数据
    public static void insert(){
        String name = "李四";
        int age  = 23;
        String description = "是个男人";
        try {
            Class.forName(DRIVER);
            Connection connection  = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //拼接SQL语句
            String sql = "insert into person(name,age,description)values('"+name+"',"+age+",'"+description+"')";  //注意拼接的格式
            Statement state = connection.createStatement();
            state.executeUpdate(sql);
            state.close();
            connection.close();
            System.out.println("插入成功！");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //方法：更新数据
    public static void update(){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "update person set age=24 where id=3";
            Statement state = connection.createStatement();
            state.executeUpdate(sql);
            state.close();
            connection.close();
            System.out.println("更新成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //方法：删除操作
    public static void delete(){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "delete from person where id=2";
            Statement state = connection.createStatement();
            state.executeUpdate(sql);
            state.close();
            connection.close();
            System.out.println("删除成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //方法:查询操作
    public static void select(){


            try{
                Class.forName(DRIVER);
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement stmt = connection.createStatement();
                System.out.println("成功连接到数据库！");

                String sql = "select * from person where id=3";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("id"+" "+"name"+" "+"age"+" ");
                while (rs.next()){
                    System.out.print(rs.getInt("ID") +" ");
                    System.out.print(rs.getString("NAME") +" ");
                    System.out.print(rs.getInt("AGE")+" " );
                    System.out.print(rs.getString("description" )+" ");
                    System.out.println();
                }
                rs.close();
                stmt.close();
                connection.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
