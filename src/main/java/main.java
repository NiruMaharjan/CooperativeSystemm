
import com.leapfrog.cooperative.dao.CustomerDAO;
import com.leapfrog.cooperative.dao.impl.CustomerDAOImpl;
import com.leapfrog.cooperative.entity.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Niru
 */
public class main {

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        try{
        Customer c=customerDAO.getById(4);
            System.out.println(c.getName());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
