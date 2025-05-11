package com.example.Assignment2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Assignment2.Model.Item;

@Service
public class ItemService {
    public List<Item> getItems() {
        return List.of(
            new Item("Nectarine Blossom & Honey Cologne"
                    , "London's Covent Garden early morning market. Succulent nectarine, peach and cassis and delicate spring flowers melt into the note of acacia honey. Sweet and delightfully playful. Now available in a larger, limited edition size."
                    ,"Alcohol Denat., Fragrance (Parfum), Water\\Aqua\\Eau, Bht, Limonene, Linalool, Citronellol, Citral, Geraniol"
                    ,"Cassis, Acacia Honey, Peach"
                    ,"/images/honey.jpg"),
            new Item("Lime Basil & Mandarin Cologne"
                    , "Our signature fragrance. Peppery basil and aromatic white thyme bring an unexpected twist to the scent of limes on a Caribbean breeze. A modern classic."
                    
                    ,"Alcohol Denat., Water\\Aqua\\Eau, Fragrance (Parfum), Limonene, Linalool, Hydroxycitronellal, Alpha-Isomethyl Ionone, Evernia Prunastri (Oakmoss) Extract, Citral, Amyl Cinnamal, Geraniol, Citronellol, Benzyl Salicylate, Hexyl Cinnamal, Eugenol, Benzyl Benzoate"
                    ,"Mandarin, Basil, Amberwood"
                    ,"/images/lime.jpg" ),
            new Item("Yuja Cologne"
                    , "This fragrance embodies the streets of Seoul, alive with a fragrant trail of yuja that enlivens the senses. For generations yuja has infused recipes and remedies alike with its distinctive and exotic notes. The mouthwatering fizziness of this striking fruit is enhanced with woody depths of cedarwood and a resinous touch of fir balsam."
                    ,""
                    ,"Yuja, Clary Sage, Fir Balsam"
                    ,"/images/london.jpg"),
            new Item("Blackberry & Bay Cologne"
                    , "Childhood memories of blackberry picking...A burst of deep, tart blackberry juice, blending with the freshness of just-gathered bay and brambly woods. Vibrant and verdant."
                    ,"Alcohol Denat., Fragrance (Parfum), Water\\Aqua\\Eau, Limonene, Linalool, Citronellol, Farnesol, Hydroxycitronellal, Geraniol, Citral, Butyl Methoxydibenzoylmethane, Tris, ..."
                    ,"Blackberry, Bay Leaves, Cedarwood"
                    , "/images/blackberry.jpg"),
            new Item("Orange Blossom Cologne"
                    , "A shimmering garden oasis. Clementine flower sparkles over a heart of orange blossom and water lily, with warm undertones of orris and balsamic vetiver. Pure delight."
                    ,"Alcohol Denat., Water\\Aqua\\Eau, Fragrance (Parfum), Linalool, Hexyl Cinnamal, Limonene, Citral, Geraniol, Farnesol"
                    ,"Clemintine Flower, White Lilac, Orriswood"
                    , "/images/orange.jpg"),
            new Item("Wood Sage & Sea Salt Cologne"
                    , "Discover the Jo Malone irresistible scent of Wood Sage and Sea Salt: escape in the freshness of the windswept shore with this earthy and mineral best selling fragrance."
                    ,"Alcohol Denat., Water\\Aqua\\Eau, Fragrance (Parfum), Limonene, Alpha-Isomethyl Ionone, Linalool, Benzyl Alcohol, Geraniol, Citronellol, Citral, Coumarin, Bht"
                    ,"Ambrette Seeds, Sea Salt, Sage"
                    , "images/jomalone.jpg")
        );
    }
}
