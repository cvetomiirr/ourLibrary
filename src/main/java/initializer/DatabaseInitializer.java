package initializer;

import domain.*;
import repository.AuthorRepository;
import repository.BasicRepository;
import repository.StoryRepository;
import util.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private final AuthorRepository authorRepository;
    private final BasicRepository bookRepository;
    private final StoryRepository storyRepository;

    @Autowired
    public DatabaseInitializer(AuthorRepository authorRepository, BasicRepository bookRepository, StoryRepository storyRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.storyRepository = storyRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Author stephenKing = new Author("Stephen", "King", "Richard Bachman", DateUtility.toInstant("1947-09-21"), Nationality.AMERICAN, Genre.HORROR);
        this.authorRepository.save(stephenKing);

        Author roxaneGay = new Author("Roxane", "Gay", "", DateUtility.toInstant("1974-10-15"), Nationality.AMERICAN, Genre.MEMORY);
        this.authorRepository.save(roxaneGay);

        Author alanMilne = new Author("Alan","Milne","A. A. Milne",DateUtility.toInstant("1882-01-18"),Nationality.ENGLISHMAN, Genre.CHILDBOOKS);
        this.authorRepository.save(alanMilne);

        Author heleneDunbar = new Author("Helene", "Dunbar", "", DateUtility.toInstant("1972-10-23"), Nationality.AMERICAN, Genre.YOUNG_ADULT);
        this.authorRepository.save(heleneDunbar);

        Author johnGreen = new Author("John", "Green", "", DateUtility.toInstant("1977-08-24"), Nationality.AMERICAN, Genre.YOUNG_ADULT);
        this.authorRepository.save(johnGreen);

        Author jenniferArmentrout = new Author("Jennifer", "Armentrout", "J. Lynn", DateUtility.toInstant("1980-06-11"), Nationality.AMERICAN, Genre.FANTASY);
        this.authorRepository.save(jenniferArmentrout);

        Author suzanneCollins = new Author("Suzanne", "Collins", "", DateUtility.toInstant("1962-08-10"), Nationality.AMERICAN, Genre.SCIENCE_FICTION );
        this.authorRepository.save(suzanneCollins);

        Author veronicaRoth = new Author("Veronica", "Roth", "", DateUtility.toInstant("1988-08-19"), Nationality.AMERICAN, Genre.FICTION );
        this.authorRepository.save(veronicaRoth);

        Author georgeMartin = new Author("George", "Martin", "GRRM", DateUtility.toInstant("1948-09-20"), Nationality.AMERICAN, Genre.FANTASY );
        this.authorRepository.save(georgeMartin);

        Author jamesDasher = new Author("James", "Dashner", "", DateUtility.toInstant("1972-11-26"), Nationality.AMERICAN, Genre.FANTASY);
        this.authorRepository.save(jamesDasher);

        Author nicholasSparks = new Author("Nicholas","Sparks", "", DateUtility.toInstant("1965-12-31"), Nationality.AMERICAN, Genre.ROMANCE);
        this.authorRepository.save(nicholasSparks);

        Author stephenieMeyer = new Author("Stephenie", "Meyer", "", DateUtility.toInstant("1973-12-24"), Nationality.AMERICAN, Genre.FANTASY  );
        this.authorRepository.save(stephenieMeyer);

        Author simoneElkeles = new Author("Simone", "Elkeles", "", DateUtility.toInstant("1970-04-24"), Nationality.AMERICAN, Genre.ROMANCE);
        this.authorRepository.save(simoneElkeles);



        Novel it = new Novel("It",DateUtility.toInstant("1987-10-01"), Language.ENGLISH, Genre.HORROR, "https://i2.wp.com/bloody-disgusting.com/wp-content/uploads/2017/04/It-Audiobook.jpg?w=402&h=565&ssl=1",
                                4.5f, stephenKing, 1116, true, false, "Welcome to Derry, Maine. It’s a small city, a place as hauntingly familiar as your own hometown. Only in Derry the haunting is real. They were seven teenagers when they first stumbled upon the horror. Now they are grown-up men and women who have gone out into the big world to gain success and happiness. But the promise they made twenty-eight years ago calls them reunite in the same place where, as teenagers, they battled an evil creature that preyed on the city’s children. Now, children are being murdered again and their repressed memories of that terrifying summer return as they prepare to once again battle the monster lurking in Derry’s sewers." );
        this.bookRepository.save(it);

        Novel doctorSleep = new Novel("Doctor Sleep", DateUtility.toInstant("2013-09-24"), Language.ENGLISH, Genre.HORROR, "https://images.gr-assets.com/books/1457473537l/18741301.jpg",
                                        4.1f, stephenKing, 531, true, true, "Stephen King returns to the characters and territory of one of his most popular novels ever, The Shining, in this instantly riveting novel about the now middle-aged Dan Torrance (the boy protagonist of The Shining) and the very special 12-year-old girl he must save from a tribe of murderous paranormals.\n" +
                "\n" +
                "On highways across America, a tribe of people called The True Knot travel in search of sustenance. They look harmless - mostly old, lots of polyester, and married to their RVs. But as Dan Torrance knows, and spunky 12-year-old Abra Stone learns, The True Knot are quasi-immortal, living off the \"steam\" that children with the \"shining\" produce when they are slowly tortured to death.\n" +
                "\n" +
                "Haunted by the inhabitants of the Overlook Hotel where he spent one horrific childhood year, Dan has been drifting for decades, desperate to shed his father's legacy of despair, alcoholism, and violence. Finally, he settles in a New Hampshire town, an AA community that sustains him, and a job at a nursing home where his remnant \"shining\" power provides the crucial final comfort to the dying. Aided by a prescient cat, he becomes \"Doctor Sleep.\"\n" +
                "\n" +
                "Then Dan meets the evanescent Abra Stone, and it is her spectacular gift, the brightest shining ever seen, that reignites Dan's own demons and summons him to a battle for Abra's soul and survival. This is an epic war between good and evil, a gory, glorious story that will thrill the millions of hyper-devoted fans of The Shining and wildly satisfy anyone new to the territory of this icon in the King canon.");
        this.bookRepository.save(doctorSleep);

        Novel hunger = new Novel("Hunger", DateUtility.toInstant("2017-06-13"), Language.ENGLISH, Genre.MEMORY, "https://images.gr-assets.com/books/1449810298l/22813605.jpg",
                                    5f, roxaneGay, 320, true, false, "New York Times bestselling author Roxane Gay has written with intimacy and sensitivity about food and bodies, using her own emotional and psychological struggles as a means of exploring our shared anxieties over pleasure, consumption, appearance, and health. As a woman who describes her own body as “wildly undisciplined,” Roxane understands the tension between desire and denial, between self-comfort and self-care. In Hunger, she casts an insightful and critical eye on her childhood, teens, and twenties—including the devastating act of violence that acted as a turning point in her young life—and brings readers into the present and the realities, pains, and joys of her daily life.\n" +
                "\n" +
                "With the bracing candor, vulnerability, and authority that have made her one of the most admired voices of her generation, Roxane explores what it means to be overweight in a time when the bigger you are, the less you are seen. Hunger is a deeply personal memoir from one of our finest writers, and tells a story that hasn’t yet been told but needs to be.");
        this.bookRepository.save(hunger);

        Novel theShining = new Novel("The Shining", DateUtility.toInstant("1977-01-28"), Language.ENGLISH, Genre.HORROR, "https://images.gr-assets.com/books/1353277730l/11588.jpg",
                                        4.19f, stephenKing, 447, true, true, "Jack Torrance's new job at the Overlook Hotel is the perfect chance for a fresh start. As the off-season caretaker at the atmospheric old hotel, he'll have plenty of time to spend reconnecting with his family and working on his writing. But as the harsh winter weather sets in, the idyllic location feels ever more remote...and more sinister. And the only one to notice the strange and terrible forces gathering around the Overlook is Danny Torrance, a uniquely gifted five-year-old.");
        this.bookRepository.save(theShining);

        Novel whatRemains = new Novel("What Remains", DateUtility.toInstant("2015-05-08"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1423498110l/24890845.jpg",
                                        3.86f, heleneDunbar, 288, true, false, "In less than a second... two of the things Cal Ryan cares most about—a promising baseball career and Lizzie, one of his best friends—are gone forever. In the hours that follow ... Cal's damaged heart is replaced. But his life will never be the same. Everyone expects him to pick up the pieces and move on. But Lizzie is gone, and all that remains for Cal is an overwhelming sense that her death was his fault. And a voice in his head that just . . . won't . . . stop. Cal thought he and his friends could overcome any obstacle. But grief might be the one exception. And that might take a lifetime to accept . . . " );
        this.bookRepository.save(whatRemains);

        Novel theseGentleWounds = new Novel("These Gentle Wounds", DateUtility.toInstant("2014-05-08"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1423498110l/24890845.jpg",
                4.05f, heleneDunbar, 307, true, false, "Sometimes I wish I’d lost a leg or something. Everyone can understand that. They never get it when what’s been broken is inside your head.\n" +
                "\n" +
                "Five years after an unspeakable tragedy that changed him forever, Gordie Allen has made a new home with his half-brother Kevin. Their arrangement works since Kevin is the only person who can protect Gordie at school and keep him focused on getting his life back on track. \n" +
                "\n" +
                "But just when it seems like things are becoming normal, Gordie’s biological father comes back into the picture, demanding a place in his life. Now there’s nothing to stop Gordie from falling into a tailspin that could cost him everything—including his relationship with Sarah, the first girl he’s trusted with the truth. With his world spinning out of control, the only one who can help Gordie is himself . . . if he can find the strength to confront the past and take back his future.");
        this.bookRepository.save(theseGentleWounds);

        Novel lookingForAlaska = new Novel("Looking for Alaska", DateUtility.toInstant("2006-12-28"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1423498110l/24890845.jpg",
                4.07f, johnGreen, 221, true, false, "Before. Miles “Pudge” Halter is done with his safe life at home. His whole life has been one big non-event, and his obsession with famous last words has only made him crave “the Great Perhaps” even more (Francois Rabelais, poet). He heads off to the sometimes crazy and anything-but-boring world of Culver Creek Boarding School, and his life becomes the opposite of safe. Because down the hall is Alaska Young. The gorgeous, clever, funny, sexy, self-destructive, screwed up, and utterly fascinating Alaska Young. She is an event unto herself. She pulls Pudge into her world, launches him into the Great Perhaps, and steals his heart. Then. . . . \n" +
                "After. Nothing is ever the same.");
        this.bookRepository.save(lookingForAlaska);

        Novel theFaultInOurStars = new Novel("The Fault in Our Stars", DateUtility.toInstant("2012-01-10"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1360206420l/11870085.jpg",
                4.24f, johnGreen, 313, true, false, "Despite the tumor-shrinking medical miracle that has bought her a few years, Hazel has never been anything but terminal, her final chapter inscribed upon diagnosis. But when a gorgeous plot twist named Augustus Waters suddenly appears at Cancer Kid Support Group, Hazel's story is about to be completely rewritten.\n" +
                "\n" +
                "Insightful, bold, irreverent, and raw, The Fault in Our Stars is award-winning author John Green's most ambitious and heartbreaking work yet, brilliantly exploring the funny, thrilling, and tragic business of being alive and in love.");
        this.bookRepository.save(theFaultInOurStars);

        Novel paperTowns = new Novel("Paper Towns", DateUtility.toInstant("2009-09-22"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1349013610l/6442769.jpg",
                3.86f, johnGreen, 305, true, false, "Who is the real Margo?" + "\n" +
                "Quentin Jacobsen has spent a lifetime loving the magnificently adventurous Margo Roth Spiegelman from afar. So when she cracks open a window and climbs into his life—dressed like a ninja and summoning him for an ingenious campaign of revenge—he follows. After their all-nighter ends, and a new day breaks, Q arrives at school to discover that Margo, always an enigma, has now become a mystery. But Q soon learns that there are clues—and they're for him. Urged down a disconnected path, the closer he gets, the less Q sees the girl he thought he knew...");
        this.bookRepository.save(paperTowns);

        Novel onyx = new Novel("Onyx", DateUtility.toInstant("2012-08-14"), Language.ENGLISH, Genre.FANTASY, "https://images.gr-assets.com/books/1329408511l/13047090.jpg",
                4.32f, jenniferArmentrout, 366, true, true, "Being connected to Daemon Black sucks…\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Thanks to his alien mojo, Daemon’s determined to prove what he feels for me is more than a product of our bizarro connection. So I’ve sworn him off, even though he’s running more hot than cold these days. But we’ve got bigger problems.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Something worse than the Arum has come to town…\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"The Department of Defense are here. If they ever find out what Daemon can do and that we're linked, I’m a goner. So is he. And there's this new boy in school who’s got a secret of his own. He knows what’s happened to me and he can help, but to do so, I have to lie to Daemon and stay away from him. Like that's possible. Against all common sense, I'm falling for Daemon. Hard.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"But then everything changes…\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"I’ve seen someone who shouldn’t be alive. And I have to tell Daemon, even though I know he’s never going to stop searching until he gets the truth. What happened to his brother? Who betrayed him? And what does the DOD want from them—from me?\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"No one is who they seem. And not everyone will survive the lies…");
        this.bookRepository.save(onyx);

        Novel obsidian = new Novel("Obsidian", DateUtility.toInstant("2012-05-08"), Language.ENGLISH, Genre.FANTASY, "http://t0.gstatic.com/images?q=tbn:ANd9GcRnK_veIP5Fr3a1CRS_B5e3Y93knzNq5ekf8I_C1de-1aZn6gtH",
                4.22f, jenniferArmentrout, 335, true, true, "Starting over sucks.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"When we moved to West Virginia right before my senior year, I’d pretty much resigned myself to thick accents, dodgy internet access, and a whole lot of boring… until I spotted my hot neighbor, with his looming height and eerie green eyes. Things were looking up.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"And then he opened his mouth.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Daemon is infuriating. Arrogant. Stab-worthy. We do not get along. At all. But when a stranger attacks me and Daemon literally freezes time with a wave of his hand, well, something… unexpected happens. \\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"The hot alien living next door marks me.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"You heard me. Alien. Turns out Daemon and his sister have a galaxy of enemies wanting to steal their abilities, and Daemon’s touch has me lit up like the Vegas Strip. The only way I’m getting out of this alive is by sticking close to Daemon until my alien mojo fades. \\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"If I don’t kill him first, that is.");
        this.bookRepository.save(obsidian);

        Novel theHungerGames = new Novel("The Hunger Games", DateUtility.toInstant("2008-09-14"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1447303603l/2767052.jpg",
               4.33f, suzanneCollins, 374, true, true, "Winning will make you famous. \\n\" +\n" +
                "                \"Losing means certain death.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"The nation of Panem, formed from a post-apocalyptic North America, is a country that consists of a wealthy Capitol region surrounded by 12 poorer districts. Early in its history, a rebellion led by a 13th district against the Capitol resulted in its destruction and the creation of an annual televised event known as the Hunger Games. In punishment, and as a reminder of the power and grace of the Capitol, each district must yield one boy and one girl between the ages of 12 and 18 through a lottery system to participate in the games. The 'tributes' are chosen during the annual Reaping and are forced to fight to the death, leaving only one survivor to claim victory.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"When 16-year-old Katniss's young sister, Prim, is selected as District 12's female representative, Katniss volunteers to take her place. She and her male counterpart Peeta, are pitted against bigger, stronger representatives, some of whom have trained for this their whole lives. , she sees it as a death sentence. But Katniss has been close to death before. For her, survival is second nature.");
        this.bookRepository.save(theHungerGames);

        Novel catchingFire = new Novel("Catching Fire", DateUtility.toInstant("2009-09-01"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1358273780l/6148028.jpg",
                4.29f, suzanneCollins, 391, true, true, "Sparks are igniting.\\n\" +\n" +
                "                \"Flames are spreading.\\n\" +\n" +
                "                \"And the Capitol wants revenge.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Against all odds, Katniss has won the Hunger Games. She and fellow District 12 tribute Peeta Mellark are miraculously still alive. Katniss should be relieved, happy even. After all, she has returned to her family and her longtime friend, Gale. Yet nothing is the way Katniss wishes it to be. Gale holds her at an icy distance. Peeta has turned his back on her completely. And there are whispers of a rebellion against the Capitol - a rebellion that Katniss and Peeta may have helped create.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Much to her shock, Katniss has fueled an unrest she's afraid she cannot stop. And what scares her even more is that she's not entirely convinced she should try. As time draws near for Katniss and Peeta to visit the districts on the Capitol's cruel Victory Tour, the stakes are higher than ever. If they can't prove, without a shadow of a doubt, that they are lost in their love for each other, the consequences will be horrifying.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"In Catching Fire, the second novel in the Hunger Games trilogy, Suzanne Collins continues the story of Katniss Everdeen, testing her more than ever before...and surprising readers at every turn.");
        this.bookRepository.save(catchingFire);

        Novel mockingjay = new Novel("Mockingjay", DateUtility.toInstant("2010-08-24"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1358275419l/7260188.jpg",
                4.03f, suzanneCollins, 392, true, true, "My name is Katniss Everdeen.\\n\" +\n" +
                "                \"Why am I not dead?\\n\" +\n" +
                "                \"I should be dead.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Katniss Everdeen, girl on fire, has survived, even though her home has been destroyed. Gale has escaped. Katniss's family is safe. Peeta has been captured by the Capitol. District 13 really does exist. There are rebels. There are new leaders. A revolution is unfolding.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"It is by design that Katniss was rescued from the arena in the cruel and haunting Quarter Quell, and it is by design that she has long been part of the revolution without knowing it. District 13 has come out of the shadows and is plotting to overthrow the Capitol. Everyone, it seems, has had a hand in the carefully laid plans--except Katniss.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"The success of the rebellion hinges on Katniss's willingness to be a pawn, to accept responsibility for countless lives, and to change the course of the future of Panem. To do this, she must put aside her feelings of anger and distrust. She must become the rebels' Mockingjay--no matter what the personal cost.");
        this.bookRepository.save(mockingjay);

        Novel divergent = new Novel("Divergent", DateUtility.toInstant("2012-02-28"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1328559506l/13335037.jpg",
                4.22f, veronicaRoth, 487, true, true, "In Beatrice Prior's dystopian Chicago world, society is divided into five factions, each dedicated to the cultivation of a particular virtue—Candor (the honest), Abnegation (the selfless), Dauntless (the brave), Amity (the peaceful), and Erudite (the intelligent). On an appointed day of every year, all sixteen-year-olds must select the faction to which they will devote the rest of their lives. For Beatrice, the decision is between staying with her family and being who she really is—she can't have both. So she makes a choice that surprises everyone, including herself.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"During the highly competitive initiation that follows, Beatrice renames herself Tris and struggles alongside her fellow initiates to live out the choice they have made. Together they must undergo extreme physical tests of endurance and intense psychological simulations, some with devastating consequences. As initiation transforms them all, Tris must determine who her friends really are—and where, exactly, a romance with a sometimes fascinating, sometimes exasperating boy fits into the life she's chosen. But Tris also has a secret, one she's kept hidden from everyone because she's been warned it can mean death. And as she discovers unrest and growing conflict that threaten to unravel her seemingly perfect society, she also learns that her secret might help her save those she loves . . . or it might destroy her.");
        this.bookRepository.save(divergent);

        Novel insurgent = new Novel("Insurgent", DateUtility.toInstant("2012-05-01"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1325667729l/11735983.jpg",
                4.06f, veronicaRoth, 525, true, true, "One choice can transform you—or it can destroy you. But every choice has consequences, and as unrest surges in the factions all around her, Tris Prior must continue trying to save those she loves—and herself—while grappling with haunting questions of grief and forgiveness, identity and loyalty, politics and love.\n" +
                "\n" +
                "Tris's initiation day should have been marked by celebration and victory with her chosen faction; instead, the day ended with unspeakable horrors. War now looms as conflict between the factions and their ideologies grows. And in times of war, sides must be chosen, secrets will emerge, and choices will become even more irrevocable—and even more powerful. Transformed by her own decisions but also by haunting grief and guilt, radical new discoveries, and shifting relationships, Tris must fully embrace her Divergence, even if she does not know what she may lose by doing so.\n" +
                "\n" +
                "New York Times bestselling author Veronica Roth's much-anticipated second book of the dystopian DIVERGENT series is another intoxicating thrill ride of a story, rich with hallmark twists, heartbreaks, romance, and powerful insights about human nature.");
        this.bookRepository.save(insurgent);

        Novel allegiant = new Novel("Allegiant", DateUtility.toInstant("2013-10-22"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1395582745l/18710190.jpg",
                3.63f, veronicaRoth, 526, true, true, "The faction-based society that Tris Prior once believed in is shattered - fractured by violence and power struggles and scarred by loss and betrayal. So when offered a chance to explore the world past the limits she's known, Tris is ready. Perhaps beyond the fence, she and Tobias will find a simple new life together, free from complicated lies, tangled loyalties, and painful memories.\n" +
                "\n" +
                "But Tris's new reality is even more alarming than the one she left behind. Old discoveries are quickly rendered meaningliess. Explosive new truths change the hearts of those she loves. And once again, Tris must battle to comprehend to complexities of human nature - and of herself - while facing impossible choices about courage, allegiance, sacrifice, and love.\n" +
                "\n" +
                "Told from a riveting dual perspective, ALLEGIANT, by #1 New York Times best-selling author Veronica Roth, brings the DIVERGENT series to a powerful conclusion while revealing the secrets of the dystopian world that has captivated millions of readers in DIVERGENT and INSURGENT.");
        this.bookRepository.save(allegiant);

        Novel aGameOfThrones = new Novel("A Game of Thrones", DateUtility.toInstant("1996-08-06"),Language.ENGLISH, Genre.FANTASY, "https://images.gr-assets.com/books/1436732693l/13496.jpg",
                4.45f, georgeMartin, 848, true, true, "Long ago, in a time forgotten, a preternatural event threw the seasons out of balance. In a land where summers can last decades and winters a lifetime, trouble is brewing. The cold is returning, and in the frozen wastes to the north of Winterfell, sinister and supernatural forces are massing beyond the kingdom’s protective Wall. At the center of the conflict lie the Starks of Winterfell, a family as harsh and unyielding as the land they were born to. Sweeping from a land of brutal cold to a distant summertime kingdom of epicurean plenty, here is a tale of lords and ladies, soldiers and sorcerers, assassins and bastards, who come together in a time of grim omens.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Here an enigmatic band of warriors bear swords of no human metal; a tribe of fierce wildlings carry men off into madness; a cruel young dragon prince barters his sister to win back his throne; and a determined woman undertakes the most treacherous of journeys. Amid plots and counterplots, tragedy and betrayal, victory and terror, the fate of the Starks, their allies, and their enemies hangs perilously in the balance, as each endeavors to win that deadliest of conflicts: the game of thrones.");
        this.bookRepository.save(aGameOfThrones);

        Novel aFeastForCrows = new Novel("A Feast for Crows", DateUtility.toInstant("2005-10-17"), Language.ENGLISH, Genre.FANTASY, "https://images.gr-assets.com/books/1429538615l/13497.jpg",
                4.12f, georgeMartin, 1061, true, true, "With A Feast for Crows, Martin delivers the long-awaited fourth volume of the landmark series that has redefined imaginative fiction and stands as a modern masterpiece in the making.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"After centuries of bitter strife, the seven powers dividing the land have beaten one another into an uneasy truce. But it's not long before the survivors, outlaws, renegades, and carrion eaters of the Seven Kingdoms gather. Now, as the human crows assemble over a banquet of ashes, daring new plots and dangerous new alliances are formed while surprising faces—some familiar, others only just appearing—emerge from an ominous twilight of past struggles and chaos to take up the challenges of the terrible times ahead. Nobles and commoners, soldiers and sorcerers, assassins and sages, are coming together to stake their fortunes...and their lives. For at a feast for crows, many are the guests—but only a few are the survivors.");
        this.bookRepository.save(aFeastForCrows);

        Novel theMazeRunner = new Novel("The Maze Runner", DateUtility.toInstant("2009-10-06"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1375596592l/6186357.jpg",
                4.03f, jamesDasher, 384, true, true, "If you ain’t scared, you ain’t human.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"When Thomas wakes up in the lift, the only thing he can remember is his name. He’s surrounded by strangers—boys whose memories are also gone.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Nice to meet ya, shank. Welcome to the Glade.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Outside the towering stone walls that surround the Glade is a limitless, ever-changing maze. It’s the only way out—and no one’s ever made it through alive.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Everything is going to change.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Then a girl arrives. The first girl ever. And the message she delivers is terrifying.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Remember. Survive. Run.");
        this.bookRepository.save(theMazeRunner);

        Novel theEyeOfMinds = new Novel("The Eye of Minds", DateUtility.toInstant("2013-09-27"), Language.ENGLISH,Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1358659346l/16279856.jpg",
                3.86f, jamesDasher, 308, true, true, "Michael is a gamer. And like most gamers, he almost spends more time on the VirtNet than in the actual world. The VirtNet offers total mind and body immersion, and it’s addictive. Thanks to technology, anyone with enough money can experience fantasy worlds, risk their life without the chance of death, or just hang around with Virt-friends. And the more hacking skills you have, the more fun. Why bother following the rules when most of them are dumb, anyway?\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"But some rules were made for a reason. Some technology is too dangerous to fool with. And recent reports claim that one gamer is going beyond what any gamer has done before: he’s holding players hostage inside the VirtNet. The effects are horrific—the hostages have all been declared brain-dead. Yet the gamer’s motives are a mystery.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"The government knows that to catch a hacker, you need a hacker.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"And they’ve been watching Michael. They want him on their team.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"But the risk is enormous. If he accepts their challenge, Michael will need to go off the VirtNet grid. There are back alleys and corners in the system human eyes have never seen and predators he can’t even fathom—and there’s the possibility that the line between game and reality will be blurred forever.");
        this.bookRepository.save(theEyeOfMinds);

        Novel theJournalOfCuriousLetters = new Novel("The Journal of Curious Letters", DateUtility.toInstant("2008-03-03"), Language.ENGLISH, Genre.FANTASY, "https://images.gr-assets.com/books/1414559824l/2219694.jpg",
                3.93f, jamesDasher, 432, true, true, "What if every time you made a choice that had a significant consequence, a new, alternate reality was created--the life that would've been had you made the other choice? What if those new realities were in danger? What if it fell to you to save all the realities? Atticus Higginbottom, a.k.a. Tick, is an average thirteen-year-old boy until the day a strange letter arrives in his mailbox. Postmarked from Alaska and cryptically signed with the initials \"M.G.,\" the letter informs Tick that dangerous--perhaps even deadly--events have been set in motion that could result in the destruction of reality itself. M.G. promises to send Tick twelve riddles that will reveal on a certain day, at a certain time, at a certain place, something extraordinary will happen. Will Tick have the courage to follow the twelve clues M.G. sends to him? Will he be able to solve the riddles in time? Will Tick discover the life he was meant to live? The first volume of an outstanding new children's fantasy series, The Journal of Curious Letters is filled with adventure, humor, riddles, and, oh, yes--danger... As M.G. warns Tick, Very frightening things are coming your way. Will you join Tick and his friends on an amazing journey through the Realities? What will your choice be?");
        this.bookRepository.save(theJournalOfCuriousLetters);

        Novel theNotebook = new Novel("The Notebook", DateUtility.toInstant("1996-10-01"), Language.ENGLISH, Genre.ROMANCE, "https://images.gr-assets.com/books/1483183484l/33648131.jpg",
                4.07f, nicholasSparks, 227, true, true, "Set amid the austere beauty of the North Carolina coast, The Notebook begins with the story of Noah Calhoun, a rural Southerner recently returned form the Second World War. Noah is restoring a plantation home to its former glory, and he is haunted by images of the beautiful girl he met fourteen years earlier, a girl he loved like no other. Unable to find her, yet unwilling to forget the summer they spent together, Noah is content to live with only memories...until she unexpectedly returns to his town to see him once again.\n" +
                "\n" +
                "Like a puzzle within a puzzle, the story of Noah and Allie is just the beginning. As it unfolds, their tale miraculously becomes something different, with much higher stakes. The result is a deeply moving portrait of love itself, the tender moments and the fundamental changes that affect us all. It is a story of miracles and emotions that will stay with you forever.");
        this.bookRepository.save(theNotebook);

        Novel theGuardian = new Novel("The Guardian", DateUtility.toInstant("2005-04-01"), Language.ENGLISH, Genre.ROMANCE, "https://images.gr-assets.com/books/1388195339l/15925.jpg",
                4.15f, nicholasSparks, 400, true, false, "Julie Barenson's young husband left her two unexpected gifts before he died: a Great Dane puppy named Singer and the promise that he would always be watching over her. Now, four years have passed. Still living in the small town of Swansboro, North Carolina, 29-year-old Julie is emotionally ready to make a commitment to someone again. But who? Should it be Richard Franklin, the handsome, sophisticated engineer who treats her like a queen? Or Mike Harris, the down-to-earth nice guy who was her husband's best friend? Choosing one of them should bring her more happiness than she's had in years. Instead, Julie is soon fighting for her life in a nightmare spawned by a chilling deception and jealousy so poisonous that it has become a murderous desire.");
        this.bookRepository.save(theGuardian);

        Novel aWalkToRemember = new Novel("A Walk to Remember", DateUtility.toInstant("2000-05-24"), Language.ENGLISH, Genre.ROMANCE, "https://images.gr-assets.com/books/1498755310l/35545737.jpg",
                4.15f, nicholasSparks, 215, true, false, "There was a time when the world was sweeter...when the women in Beaufort, North Carolina, wore dresses, and the men donned hats...when something happened to a seventeen-year-old boy that would change his life forever. Every April, when the wind blows in from the sea and mingles with the scent of lilacs, Landon Carter remembers his last year at Beaufort High. It was 1958, and Landon had already dated a girl or two. He even swore that he had once been in love. Certainly the last person in town he thought he'd fall for was Jamie Sullivan, the daughter of the town's Baptist minister. A quiet girl who always carried a Bible with her schoolbooks, Jamie seemed content living in a world apart from the other teens. She took care of her widowed father, rescued hurt animals, and helped out at the local orphanage. No boy had ever asked her out. Landon would never have dreamed of it. Then a twist of fate made Jamie his partner for the homecoming dance, and Landon Carter's life would never be the same. Being with Jamie would show him the depths of the human heart and lead him to a decision so stunning it would send him irrevocably on the road to manhood. No other author today touches our emotions more deeply than Nicholas Sparks.\n" +
                "Illuminating both the strength and the gossamer fragility of our deepest emotions, his two New York Times bestsellers, The Notebook and Message in a Bottle, have established him as the leading author of today's most cherished love stories. Now, in A Walk to Remember, he tells a truly unforgettable story, one that glimmers with all of his magic, holding us spellbound-and reminding us that in life each of us may find one great love, the kind that changes everything... ");
        this.bookRepository.save(aWalkToRemember);

        Novel twilight = new Novel("Twilight", DateUtility.toInstant("2005-10-05"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1361039443l/41865.jpg",
                3.58f, stephenieMeyer, 498, true, true, "About three things I was absolutely positive.\n" +
                "\n" +
                "First, Edward was a vampire.\n" +
                "\n" +
                "Second, there was a part of him—and I didn't know how dominant that part might be—that thirsted for my blood.\n" +
                "\n" +
                "And third, I was unconditionally and irrevocably in love with him.\n" +
                "\n" +
                "In the first book of the Twilight Saga, internationally bestselling author Stephenie Meyer introduces Bella Swan and Edward Cullen, a pair of star-crossed lovers whose forbidden relationship ripens against the backdrop of small-town suspicion and a mysterious coven of vampires. This is a love story with bite.");
        this.bookRepository.save(twilight);

        Novel theHost = new Novel("The Host", DateUtility.toInstant("2008-05-06"), Language.ENGLISH, Genre.SCIENCE_FICTION, "https://images.gr-assets.com/books/1318009171l/1656001.jpg",
                3.84f, stephenieMeyer, 620, true, true, "Melanie Stryder refuses to fade away. The earth has been invaded by a species that take over the minds of human hosts while leaving their bodies intact. Wanderer, the invading \\\"soul\\\" who has been given Melanie's body, didn't expect to find its former tenant refusing to relinquish possession of her mind.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"As Melanie fills Wanderer's thoughts with visions of Jared, a human who still lives in hiding, Wanderer begins to yearn for a man she's never met. Reluctant allies, Wanderer and Melanie set off to search for the man they both love.");
        this.bookRepository.save(theHost);

        Novel leavingParadise = new Novel("Leaving Paradise", DateUtility.toInstant("2007-04-08"), Language.ENGLISH, Genre.YOUNG_ADULT, "https://images.gr-assets.com/books/1388207436l/544424.jpg",
                4.01f, simoneElkeles, 303, true, true, "Nothing has been the same since Caleb Becker left a party drunk, got behind the wheel, and hit Maggie Armstrong. Even after months of painful physical therapy, Maggie walks with a limp. Her social life is nil and a scholarship to study abroad—her chance to escape everyone and their pitying stares—has been canceled.\n" +
                "\n" +
                "After a year in juvenile jail, Caleb’s free . . . if freedom means endless nagging from a transition coach and the prying eyes of the entire town. Coming home should feel good, but his family and ex-girlfriend seem like strangers.\n" +
                "\n" +
                "Caleb and Maggie are outsiders, pigeon-holed as \"criminal\" and \"freak.\" Then the truth emerges about what really happened the night of the accident and, once again, everything changes. It’s a bleak and tortuous journey for Caleb and Maggie, yet they end up finding comfort and strength from a surprising source: each other. ");
        this.bookRepository.save(leavingParadise);

        Novel perfectChemistry = new Novel("Perfect Chemistry", DateUtility.toInstant("2008-12-23"), Language.ENGLISH, Genre.ROMANCE, "https://images.gr-assets.com/books/1439792475l/4268157.jpg",
                4.07f, simoneElkeles,368, true, true, "A fresh, urban twist on the classic tale of star-crossed lovers.\n" +
                "\n" +
                "When Brittany Ellis walks into chemistry class on the first day of senior year, she has no clue that her carefully created 'perfect' life is about to unravel before her eyes. She's forced to be lab partners with Alex Fuentes, a gang member from the other side of town, and he is about to threaten everything she's worked so hard for: her flawless reputation, her relationship with her boyfriend, and the secret that her home life is anything but perfect. \n" +
                "\n" +
                "Alex is a bad boy and he knows it. So when he makes a bet with his friends to lure Brittany into his life, he thinks nothing of it. But soon Alex realizes Brittany is a real person with real problems, and suddenly the bet he made in arrogance turns into something much more.");
        this.bookRepository.save(perfectChemistry);


       User user1 = new User("mariya_ivanova", "Mariya", "Ivanova", "password", "mariya_ivanova@abv.bg", Role.WRITER);
       User user2 = new User("elena96", "Elena", "Gachovska", "password", "elena.g@abv.bg", Role.ADMIN);
       User user3 = new User("lubomir92", "Lubomir", "Petrov", "password", "lubomir@abv.bg", Role.WRITER);
       User user4 = new User("kolev12", "Ivaylo", "Kolev", "password", "ivaylo.kolev@abv.bg", Role.WRITER);

        Story myFirstLove = new Story("My first love", DateUtility.toInstant("2013-10-25"), Language.BULGARIAN, Genre.ROMANCE, "https://images-na.ssl-images-amazon.com/images/I/51vk-4Grp0L._SX322_BO1,204,203,200_.jpg",
                2.9f, "", "");
        this.storyRepository.save(myFirstLove);

        Story monster = new Story("Monster", DateUtility.toInstant("2017-12-03"), Language.ENGLISH, Genre.HORROR, "https://10deb7fbfece20ff53da-95da5b03499e7e5b086c55c243f676a1.ssl.cf1.rackcdn.com/e03cdd76e869f63a3aa1ed88c9cc1ecd_xl.jpg",
                4.8f, "", "");
        this.storyRepository.save(monster);

        Story bone = new Story("Bone", DateUtility.toInstant("2010-08-06"), Language.SPANISH, Genre.SCIENCE, "https://images.gr-assets.com/books/1500655149l/34879754.jpg",
                2.8f, "", "");
        this.storyRepository.save(bone);

        Story dangerousGames = new Story("Dangerous games",DateUtility.toInstant("2016-04-02"), Language.GERMAN, Genre.FANTASY, "https://drlauratisdall.files.wordpress.com/2015/06/9780520284920.jpg",
                4.2f, "", "");
        this.storyRepository.save(dangerousGames);

        Story iAmWatchingYou = new Story("I am watching you", DateUtility.toInstant("2009-09-09"), Language.ENGLISH, Genre.ROMANCE, "https://images.gr-assets.com/books/1500655149l/34879754.jpg",
                3.8f, "", "");
        this.storyRepository.save(iAmWatchingYou);

    }
}
