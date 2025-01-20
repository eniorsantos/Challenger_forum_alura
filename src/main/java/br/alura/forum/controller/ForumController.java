package br.alura.forum.controller;

import br.alura.forum.dto.DadosCadastroTopicos;
import br.alura.forum.dto.DadosCmpletosTopicos;
import br.alura.forum.dto.DadosTopicos;
import br.alura.forum.dto.DadosUpdaTopico;
import br.alura.forum.model.Topicos;
import br.alura.forum.repository.TopicosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private TopicosRepository topicosRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cadTopicos(@RequestBody @Valid DadosTopicos dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topicos(dados);
        topicosRepository.save(topico);


        System.out.println(dados);

        var uri = uriBuilder.path("/forum/{id}").buildAndExpand(topico.getId()).toUri();
        System.out.println((new DadosCmpletosTopicos(topico)));
        return ResponseEntity.created(uri).body(new DadosCmpletosTopicos(topico));
        //return ResponseEntity.ok().body(dados);
    }




    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosUpdaTopico dados) {
        var topico = topicosRepository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosCmpletosTopicos(topico));

    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var topico = topicosRepository.getReferenceById(id);
        topico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = topicosRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosCadastroTopicos(topico));
    }

    @GetMapping     //@PageableDefault(size=10, sort="nome")
    public ResponseEntity<Page<DadosCadastroTopicos>> consulta(Pageable paginacao) {
        var page = topicosRepository.findAllByAtivoTrue(paginacao).map(DadosCadastroTopicos::new);
        return ResponseEntity.ok(page);
    }

}
