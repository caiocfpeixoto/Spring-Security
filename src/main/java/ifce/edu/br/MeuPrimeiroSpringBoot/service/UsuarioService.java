package ifce.edu.br.MeuPrimeiroSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ifce.edu.br.MeuPrimeiroSpringBoot.model.Perfil;
import ifce.edu.br.MeuPrimeiroSpringBoot.model.Usuario;
import ifce.edu.br.MeuPrimeiroSpringBoot.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario= buscarPorEmail(username);
		return new User(
		usuario.getEmail(),
		usuario.getSenha(),
		AuthorityUtils.createAuthorityList(getAtuthorities(usuario.getPerfis())));
	}
	
	private String[] getAtuthorities(List<Perfil> perfis) {
		String[] authorities = new String[perfis.size()];
		for(int i = 0;i<perfis.size();i++) {
			authorities[i] = perfis.get(i).getDesc();
			
		}
		return authorities;
	}
}
