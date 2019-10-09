import org.openqa.selenium.By;

import junit.framework.Assert;
import kbernardo.autotestes.DSL;


@SuppressWarnings("deprecation")
public class SacAvPage {
	
	private DSL dsl;
	//private String user;
	
	public SacAvPage() {
		dsl = new DSL();
	}
	
	public void imprime(){
		System.out.println("Passou por aqui");
	}
	public void logarX(){
		dsl.clicarBotaoXpath("//*[@id='root']/div/div/header/nav/div/button");
	}
	public void logarXNegocie(){
		dsl.clicarBotaoXpath("//*[@id='root']/div/div/header/form/button");
	}
	
	public void setCPFX(String cpf) {
		dsl.escreverSac(By.xpath("//*[@id='root']/div/div/header/form/input"), cpf);
	}
	
	public void logar (){
		dsl.clicarBotaoXpath("//button");
		// dsl.clicarBotaoXpath("//div[@id='login']/div/div/form/button");
		// dsl.clicarBotaoXpath("//div[@id=\'login\']/div/div/form/button");
		// dsl.driver.clicarBotaoXpath("//button[@type='submit']");
		//driver.findElement(By.cssSelector(".btn")).click();
		//dsl.clicarBotaoCss(".btn");
	}

	
	
	public void setUser(String user) {
		dsl.escrever(By.id("username"),user);

	}
	public void setSenha(String senha) {
		dsl.escrever(By.id("password"),senha);
	}
	
	public String obterErro(String xPath){
		 return dsl.obterTexto(By.xpath(xPath));
	}
	public void setCPF(String cpf) {
		dsl.escreverSac(By.xpath("//*[@id='inputCPF']"), cpf);
	}
	
	public void setNomeCliente(String nome) {
		dsl.escrever("inputNomeCliente", nome);
	}
	
	public void setNascimento(String nascimento){
		dsl.escrever("inputNascimento", nascimento);
	}
	
	public void setEmail(String email){
		dsl.escrever("inputEmail", email);
	}
	
	public void setFixo(String fixo){
		dsl.escrever("inputFixo", fixo);
	}
	
	public void setMovel(String movel){
		dsl.escrever("inputMovel", movel);
	}
	
	public void setCEP(String cep){
		dsl.escrever("inputCep", cep);
	}
	
	public void setEndereco(String endereco) {
		dsl.escrever("inputEndereco", endereco);
	}
	
	public void setNumero(String numero) {
		dsl.escrever("inputNumero", numero);
	}
	
	public void setComplemento(String complemento) {
		dsl.escrever("inputComplemento", complemento);
	}
	
	public void setBairro(String bairro) {
		dsl.escrever("inputBairro", bairro);
	}
	
	
	public void setCidade(String cidade ) {
		dsl.escrever("inputCidade", cidade);
	}
	
	public void setEstado(String estado) {
		dsl.selecionarCombo("inputEstado", estado);
	}
	
	public void setOrigemAtendimento(String origemAtendimento) {
		dsl.selecionarCombo("inputOrigemAtendimento", origemAtendimento);
	}
	
	public void setCanalAtendimento(String canalAtendimento) {
		dsl.selecionarCombo("inputCanalAtendimento", canalAtendimento);
	}
	
	public void setTipoAtendimento(String tipoAtendimento) {
		dsl.selecionarCombo("inputTipoAtendimento", tipoAtendimento);
	}
	
	public void setTipoChamado(String tipoChamado) {
		dsl.selecionarCombo("inputTipoChamado", tipoChamado);
	}
	
	public void setDetalhesChamado(String detalhesChamado) {
		dsl.selecionarCombo("inputDetalhesChamado", detalhesChamado);
	}
	public void setSolucaoChamado(String solucaoChamado) {
		dsl.selecionarCombo("inputSolucaoChamado", solucaoChamado);
	}
	public void setDirecionamento(String direcionamento) {
		dsl.selecionarCombo("inputDirecionamento", direcionamento);
	}
	public void setProcedencia(String procedencia) {
		dsl.selecionarCombo("inputProcedencia", procedencia);
		
	}
	public void setObservacoes(String observacoes) {
		dsl.escrever("inputObservacoes", observacoes);
	}
	public void clickRegistrarAtendimento(String xpath){
		dsl.clicarBotaoXpath(xpath);
	}
	
	@SuppressWarnings("deprecation")
	public void ValidarAlerta(String alerta){
		Assert.assertEquals(alerta, dsl.alertaObterTextoEAceita());
	}
	public void passaAlerta(){
		 dsl.alertaAceita();
	}
	public void setsexo(String sexo) {
		dsl.selecionarCombo("InputSexo", sexo);
	}
	
	
}

