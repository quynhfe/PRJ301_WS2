    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package data;

    import common.Constant;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import model.Customer;

    /**
     *
     * @author ADMIN
     */
    public class CustomerDB {

        public boolean addCustomer(Customer c) {
            boolean check = false;
            try (PreparedStatement ps = DBContext
                    .getConnection()
                    .prepareStatement(Constant.CUSTOMER_ADD)) {
                ps.setString(1, c.getIdNo());
                ps.setString(2, c.getFirstName());
                ps.setString(3, c.getLastName());
                ps.setString(4, c.getPhoneNo());
                ps.setString(5, c.getEmail());
                ps.setString(6, c.getAddress());
                ps.setDouble(7, c.getInitialBalance());
                ps.setString(8, c.getPassword());
                int result = ps.executeUpdate();
                if (result > 0) {
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Error add user");
                e.printStackTrace();
            }
            return check;
        }

        public boolean updateCustomer(Customer c) {
            boolean check = false;
            try (PreparedStatement ps = DBContext
                    .getConnection()
                    .prepareStatement(Constant.CUSTOMER_ALL_UPDATE)) {
                ps.setNString(1, c.getFirstName());
                ps.setNString(2, c.getLastName());
                ps.setNString(3, c.getPhoneNo());
                ps.setNString(4, c.getEmail());
                ps.setNString(5, c.getAddress());
                ps.setDouble(6, c.getInitialBalance());
                ps.setNString(7, c.getPassword());
                ps.setString(8, c.getIdNo());
                int result = ps.executeUpdate();
                if (result > 0) {
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Error update Customer");
                e.printStackTrace();
            }
            return check;
        }

        public ArrayList<Customer> getAllCustomer() {
            ArrayList<Customer> accList = new ArrayList<>();
            try (PreparedStatement ps = DBContext.getConnection()
                    .prepareStatement(Constant.CUSTOMER_SELECT_ALL)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String idNo = rs.getString("idNo");
                    String firstName = rs.getNString("firstName");
                    String lastName = rs.getNString("lastName");
                    String phoneNo = rs.getNString("phoneNo");
                    String email = rs.getNString("email");
                    String address = rs.getNString("address");
                    double initialBalance = rs.getDouble("initialBalance");
                    String password = rs.getNString("password");
                    accList.add(new Customer(idNo, firstName, lastName, phoneNo, email, address, initialBalance, password));
                }
                return accList;
            } catch (Exception e) {
                System.out.println("Error get all cus ");
                e.printStackTrace();
            }
            return null;
        }

//        public static void main(String[] args) {
//            CustomerDB cus = new CustomerDB();
//            for (Customer c : cus.getAllCustomer()) {
//                System.out.println(c.toString());
//            }
//            Customer ct = new Customer("123456781", "Nguyen", "Tu", "0828197797", "an@gmail.com", "123 ABC", 5000, "an");
//            cus.updateCustomer(ct);
//            for (Customer c : cus.getAllCustomer()) {
//                System.out.println(c.toString());
//            }
//        }
    }
