package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("--- Teste 1: procura pelo id ---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n--- Teste 2: procura pelo departamento ---");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n--- Teste 3: procurar todos ---");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n--- Test 4: inserir novo vendedor ---");
		Seller newSeller = new Seller(null, "Marcos", "marcos@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("inserted new id = " + newSeller.getId());
		
		System.out.println("\n--- Test 5: atualizar um vendedor ---");
		seller = sellerDao.findById(1);
		seller.setName("Martinha Silva");
		sellerDao.update(seller);
		System.out.println("Atualizaçao feita!");
		
		System.out.println("\n--- Test 6: deletar um vendedor ---");
		System.out.println("coloque um id para deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("deletado!");
	}

}
