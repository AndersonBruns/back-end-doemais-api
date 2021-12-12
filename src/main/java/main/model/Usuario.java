package main.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Nome não pode ser vazio")
    @Column(name = "nome")
    private String nome;

    @NotEmpty(message = "CNPJ não pode ser vazio")
    @Column(name = "cnpj")
    private String cnpj;

    @NotEmpty(message = "Email não pode ser vazio")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Senha não pode ser vazio")
    @Column(name = "senha")
    private String senha;

    @NotEmpty(message = "Cep não pode ser vazio")
    @Column(name = "cep")
    private String cep;

    @NotEmpty(message = "Rua não pode ser vazio")
    @Column(name = "rua")
    private String rua;

    @NotEmpty(message = "Bairro não pode ser vazio")
    @Column(name = "bairro")
    private String bairro;

    @NotEmpty(message = "Numero não pode ser vazio")
    @Column(name = "numero")
    private Integer numero;

    @NotEmpty(message = "Estado não pode ser vazio")
    @Column(name = "estado")
    private String estado;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "referencia")
    private String referencia;

    @NotEmpty(message = "Logo não pode ser vazio")
    @Column(name = "logo")
    private String logo;

    @NotEmpty(message = "Banner não pode ser vazio")
    @Column(name = "banner")
    private String banner;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "instagram")
    private String instagram;

    @NotEmpty(message = "Telefone não pode ser vazio")
    @Column(name = "telefone")
    private String telefone;

    @Column(name = "whatsapp")
    private String whatsapp;

    @NotEmpty(message = "Descrição não pode ser vazio")
    @Column(name = "descricao")
    private String descricao;

    @NotEmpty(message = "Descrição do pedido não pode ser vazio")
    @Column(name = "pedidodesc")
    private String pedidodesc;

    @NotNull
    @JoinTable(name = "usuario_categoria",
            joinColumns = @JoinColumn(name = "Usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "id"))
    @ManyToMany
    private List<Categoria> categoria;

    @NotNull
    //@JoinTable(name = "usuario_userfoto",
    //        joinColumns = @JoinColumn(name = "Usuario_id", referencedColumnName = "id"),
    //        inverseJoinColumns = @JoinColumn(name = "userfoto_id", referencedColumnName = "id"))
    //@ManyToMany

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Foto> userfoto; //= new ArrayList<Foto>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPedidodesc() {
        return pedidodesc;
    }

    public void setPedidodesc(String pedidodesc) {
        this.pedidodesc = pedidodesc;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public List<Foto> getUserfoto() {
        return userfoto;
    }

    public void setUserfoto(List<Foto> userfoto) {
        this.userfoto = userfoto;
    }

    public Usuario(Long id) {this.id = id;}

    public Usuario() {

    }
}
