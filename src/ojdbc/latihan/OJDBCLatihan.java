/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbc.latihan;

import dao.JobGradeDAO;
import java.util.List;
import model.JobGrade;

/**
 *
 * @author Ignatius
 */
public class OJDBCLatihan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(new Koneksi().getKoneksi());
//        System.out.println(
//                new JobGradeDAO().getAllData().size());
        List<JobGrade> datas = new JobGradeDAO()
                .search("lowest_sal", "1000");
        datas = new JobGradeDAO().getAllData();
        
        JobGrade jg = new JobGradeDAO().getByGradeLevel("A");
        System.out.println(jg.getLowestSalary());
        
        JobGrade jg1 = new JobGrade("H", 1100, 210000);
        
        JobGrade jg2 = new JobGrade();
        jg2.setGradeLevel("I");
        jg2.setLowestSalary(100);
        jg2.setHighestSalary(11100);
        
//        System.out.println(new JobGradeDAO()
//                .insert(jg1));
//        System.out.println(new JobGradeDAO()
//                .insert(jg2));
//        for (int i = 0; i < datas.size(); i++) {
//            System.out.println(
//                    datas.get(i).getGradeLevel()+ 
//                    ", gaji tertinggi: "
//                    +datas.get(i).getHighestSalary());
//        }
//        System.out.println("\ndengan fore");
//        for (JobGrade data : datas) {
//            System.out.println(
//                    data.getGradeLevel()+ 
//                    ", gaji tertinggi: "
//                    +data.getHighestSalary());
//        }
        System.out.println("\ndengan forex");
        datas.forEach(x->System.out.println(
                x.getGradeLevel()+", gaji tertinggi: "+
                        x.getHighestSalary()));
    }
    
}
