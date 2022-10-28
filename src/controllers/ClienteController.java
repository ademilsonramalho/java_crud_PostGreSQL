package controllers;

import java.util.List;

import entities.Cliente;
import helpers.ClienteHelper;
import repositories.ClienteRepository;

public class ClienteController {

	// método para realizar o cadastro de um cliente
	public void cadastrarCliente() {
		try {
			System.out.println("\nCADASTRO DE CLIENTES\n");

			Cliente cliente = new Cliente();

			cliente.setNome(ClienteHelper.lerNome());
			cliente.setEmail(ClienteHelper.lerEmail());
			cliente.setTelefone(ClienteHelper.lerTelefone());

			ClienteRepository clienteRepository = new ClienteRepository();

			clienteRepository.create(cliente);

			System.out.println("\nCliente cadastrado com sucesso!");

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}

	public void atualizarCliente() {
		try {

			System.out.println("\nATUALIZAR CLIENTES\n");
			
			Integer idCliente = ClienteHelper.lerIdCliente();

			// verifica se cliente existe ????
			ClienteRepository clienteRepository = new ClienteRepository();
			
			Cliente cliente = clienteRepository.findById(idCliente);
					

			if (cliente == null) {
				System.out.println("\nCliente não encontrado, verifique o ID informado.\n");
			}
			else {
				cliente.setNome(ClienteHelper.lerNome());
				cliente.setEmail(ClienteHelper.lerEmail());
				cliente.setTelefone(ClienteHelper.lerTelefone());
				clienteRepository.update(cliente);
			}

			System.out.println("\nCliente atualizado com sucesso!");

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
	
	public void excluirCliente() {
		try {
			System.out.println("\nEXCLUIR CLIENTE\n");
			
			Integer idCliente = ClienteHelper.lerIdCliente();

			// verifica se cliente existe ????
			ClienteRepository clienteRepository = new ClienteRepository();
			
			Cliente cliente = clienteRepository.findById(idCliente);	

			if (cliente == null) {
				System.out.println("\nCliente não encontrado, verifique o ID informado.\n");
			}
			else {
				System.out.println(" Nome cliente ............... " + cliente.getNome());
				System.out.println(" Email ...................... " + cliente.getEmail());
				System.out.println(" Telefone.................... " + cliente.getTelefone());
							
				clienteRepository.delete(cliente);
				System.out.println("\nCliente excluído com sucesso!");
			}

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
	
	public void consultarClientes() {
		try {

			System.out.println("\nCONSULTA DE CLIENTES\n");

			ClienteRepository clienteRepository = new ClienteRepository();

			List<Cliente> lista = clienteRepository.findAll();
			System.out.println("\nTotal de clientes: " + lista.size());

			for (Cliente cliente : lista) {
				System.out.println("-------------------------------------------------------------");
				System.out.println(" ID Cliente ....: " + cliente.getIdCliente());
				System.out.println(" Nome ..........: " + cliente.getNome());
				System.out.println(" Email .........: " + cliente.getEmail());
				System.out.println(" telefone ......: " + cliente.getTelefone());
				System.out.println("-------------------------------------------------------------");
			}	
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
	
	
}
