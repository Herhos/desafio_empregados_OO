package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program
{

	public static void main(String[] args)
	{
		// DESAFIO EMPREGADOS OO
		
		Locale.setDefault(Locale.US);
		
		try (Scanner scn = new Scanner(System.in))
		{
			System.out.print("Nome do departamento: ");
			String nomeDepto = scn.nextLine();
			
			System.out.print("Dia do pagamento: ");
			Integer diaPagto = scn.nextInt();
			
			System.out.print("E-mail: ");
			scn.nextLine();
			String email = scn.nextLine();
			
			System.out.print("Telefone: ");
			String telefone = scn.nextLine();
			
			Address endereco = new Address(email, telefone);
			
			Department departamento = new Department(nomeDepto, diaPagto, endereco);
			
			System.out.print("Quantos funcionários tem o departamento? ");
			int n = scn.nextInt();
			
			for(int i = 0; i < n; i++)
			{
				System.out.println("Dados do funcionário " + (i + 1) + ":");
				
				System.out.print("Nome: ");
				scn.nextLine();
				String nomeFunc = scn.nextLine();
				
				System.out.print("Salário: ");
				Double salario = scn.nextDouble();
				
				Employee empregado = new Employee(nomeFunc, salario);
				departamento.addEmployee(empregado);
			}
			
			showReport(departamento);
			
			scn.close();
		}
	}
	
	public static void showReport(Department dept)
	{		
		StringBuilder sbd = new StringBuilder();
		sbd.append("\n");
		sbd.append("FOLHA DE PAGAMENTO: \n");
		sbd.append("Departamento " + dept.getName());
		sbd.append(" = R$ " + String.format("%.2f", dept.payroll()) + "\n");
		sbd.append("Pagamento realizado no dia " + dept.getPayDay() + "\n");
		sbd.append("Funcionários: \n");		
		sbd.append(dept.toString());
		sbd.append("Para dúvidas, favor entrar em contato: " + dept.getAddresses().getEmail());
		System.out.println(sbd.toString());
	}
}
