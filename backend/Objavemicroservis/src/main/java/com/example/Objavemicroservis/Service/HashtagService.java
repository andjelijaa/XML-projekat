package com.example.Objavemicroservis.service;


import java.util.List;


@Service
public class HashtagService implements IHashtagService {

    @Autowired
    private HashtagRepository tagRepository;

    @Override
    public List<Hashtag> getAll() {
        List<Hashtag> tags = tagRepository.pronadjiSve();
        if (tags.isEmpty())
            return tags;
    }

    @Override
    public Hashtag kreiraj(Hashtag tag) {
        return tagRepository.sacuvaj(tag);
    }

    @Override
    public List<Hashtag> kreirajTagove(List<String> tags) {
        List<Hashtag> tagDb = new ArrayList<>();
        for (String t : tags) {
            if (tagRepository.pronadjiPoImenu(t) == null) {
                Hashtag tag = new Hashtag();
                tag.setName(t.toLowerCase());
                kreiraj(tag);
                tagDb.add(tag);
            }
        }
        return tagDb;
    }

}