package com.example.moviecatalogue.core.utils

import com.example.moviecatalogue.core.data.source.remote.response.movie.MovieResponse
import com.example.moviecatalogue.core.data.source.remote.response.tvshow.TvshowResponse
import com.example.moviecatalogue.core.data.vo.Resource
import com.example.moviecatalogue.core.domain.model.MovieEntityDomain
import com.example.moviecatalogue.core.domain.model.TvshowEntityDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


object DataDummy {
    fun generateDummyMovies(): List<MovieEntityDomain> {
        val movies = ArrayList<MovieEntityDomain>()
        movies.add(
            MovieEntityDomain(
                27205,
                title = "Inception",
                releaseDate = "2010-07-15",
                rate = "8.3",
                overview = "Cobb, a skilled thief who commits corporate espionage by infiltrating the subconscious of his targets is offered a chance to regain his old life as payment for a task considered to be impossible: \"inception\", the implantation of another person's idea into a target's subconscious.",
                posterPath = "https://image.tmdb.org/t/p/w185/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/s3TBrRGB1iav7gFOCNx3H31MoES.jpg",
                isFavorite = false

            )
        )
        movies.add(
            MovieEntityDomain(
                583083,
                title = "The Kissing Booth 2",
                releaseDate = "2020-07-24",
                rate = "8.2",
                overview = "With college decisions looming, Elle juggles her long-distance romance with Noah, changing relationship with bestie Lee and feelings for a new classmate.",
                posterPath = "https://image.tmdb.org/t/p/w185/mb7wQv0adK3kjOUr9n93mANHhPJ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185//wO5QSWZPBT71gMLvrRex0bVc0V9.jpg",
                isFavorite = false

            )
        )
        movies.add(
            MovieEntityDomain(
                516486,
                title = "Greyhound",
                releaseDate = "2020-07-10",
                rate = "7.5",
                overview = "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
                posterPath = "https://image.tmdb.org/t/p/w185/kjMbDciooTbJPofVXgAoFjfX8Of.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg",
                isFavorite = false
            )
        )
        movies.add(
            MovieEntityDomain(
                313369,
                title = "La La Land",
                releaseDate = "2016-11-29",
                rate = "7.9",
                overview = "Mia, an aspiring actress, serves lattes to movie stars in between auditions and Sebastian, a jazz musician, scrapes by playing cocktail party gigs in dingy bars, but as success mounts they are faced with decisions that begin to fray the fragile fabric of their love affair, and the dreams they worked so hard to maintain in each other threaten to rip them apart.",
                posterPath = "https://image.tmdb.org/t/p/w185/uDO8zWDhfWwoFdKS4fzkUJt0Rf0.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/qJeU7KM4nT2C1WpOrwPcSDGFUWE.jpg",
                isFavorite = false
            )
        )
        movies.add(
            MovieEntityDomain(
                547016,
                title = "The Old Guard",
                releaseDate = "2020-07-10",
                rate = "7.4",
                overview = "Four undying warriors who've secretly protected humanity for centuries become targeted for their mysterious powers just as they discover a new immortal.",
                posterPath = "https://image.tmdb.org/t/p/w185/cjr4NWURcVN3gW5FlHeabgBHLrY.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/m0ObOaJBerZ3Unc74l471ar8Iiy.jpg",
                isFavorite = false
            )
        )
        movies.add(
            MovieEntityDomain(
                300671,
                title = "13 Hours: The Secret Soldiers of Benghazi",
                releaseDate = "2016-01-13",
                rate = "7.1",
                overview = "An American Ambassador is killed during an attack at a U.S. compound in Libya as a security team struggles to make sense out of the chaos.",
                posterPath = "https://image.tmdb.org/t/p/w185/4qnEeVPM8Yn5dIVC4k4yyjrUXeR.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/ayDMYGUNVvXS76wQgFwTiUIDNb5.jpg",
                isFavorite = false
            )
        )
        movies.add(
            MovieEntityDomain(
                454983,
                title = "The Kissing Booth",
                releaseDate = "2018-05-11",
                rate = "7.3",
                overview = "When teenager Elle's first kiss leads to a forbidden romance with the hottest boy in high school, she risks her relationship with her best friend.",
                posterPath = "https://image.tmdb.org/t/p/w185/7Dktk2ST6aL8h9Oe5rpk903VLhx.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/itiz2OBK4ns6XT0ufXtusojmMt9.jpg",
                isFavorite = false
            )
        )
        movies.add(
            MovieEntityDomain(
                419704,
                title = "Ad Astra",
                releaseDate = "2019-09-17",
                rate = "6.1",
                overview = "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.",
                posterPath = "https://image.tmdb.org/t/p/w185/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/AeDS2MKGFy6QcjgWbJBde0Ga6Hd.jpg",
                isFavorite = false
            )
        )
        movies.add(
            MovieEntityDomain(
                587792,
                title = "Palm Springs",
                releaseDate = "2020-01-26",
                rate = "7.7",
                overview = "When carefree Nyles and reluctant maid of honor Sarah have a chance encounter at a Palm Springs wedding, things get complicated when they find themselves unable to escape the venue, themselves, or each other.",
                posterPath = "https://image.tmdb.org/t/p/w185/yf5IuMW6GHghu39kxA0oFx7Bxmj.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/d7JUXVvjvVCXWs1mlpyO5ESdWdT.jpg",
                isFavorite = false
            )
        )
        movies.add(
            MovieEntityDomain(
                695476,
                title = "Father Soldier Son",
                releaseDate = "2020-07-17",
                rate = "5.3",
                overview = "When Sgt. First Class Brian Eisch is critically wounded in Afghanistan, it sets him and his sons on a journey of love, loss, redemption and legacy.",
                posterPath = "https://image.tmdb.org/t/p/w185/7AIU4rH3ExBHQg92UHYxFYxP82M.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/8IjnyGbzcX5Ulb4kXLnecgWDEYA.jpg",
                isFavorite = false
            )
        )
        movies.add(
            MovieEntityDomain(
                454626,
                title = "Sonic the Hedgehog",
                releaseDate = "2020-02-12",
                rate = "7.5",
                overview = "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
                posterPath = "https://image.tmdb.org/t/p/w185/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w185/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
                isFavorite = false
            )
        )
        return movies
    }
    suspend fun getAllDummyMovies():Flow<Resource<List<MovieEntityDomain>>>{
        return flow {
            val result= generateDummyMovies()
            if (result.isNotEmpty()){
                emit(Resource.Success(result))
            }else if(result.isEmpty()){
                emit(Resource.Error("Kosong"))
            }
        }
    }

    fun generateDummyTv(): List<TvshowEntityDomain> {
        val tv = ArrayList<TvshowEntityDomain>()
        tv.add(
            TvshowEntityDomain(
                456,
                "The Simpsons",
                "1989-12-16",
                7.6,
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "https://image.tmdb.org/t/p/w185/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "https://image.tmdb.org/t/p/w185/adZ9ldSlkGfLfsHNbh37ZThCcgU.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                2734,
                "Law & Order: Special Victims Unit",
                "1999-09-20",
                7.3,
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                "https://image.tmdb.org/t/p/w185/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "https://image.tmdb.org/t/p/w185/cD9PxbrdWYgL7MUpD9eOYuiSe2P.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                1668,
                "Friends",
                "1994-09-22",
                8.2,
                "The misadventures of a group of friends as they navigate the pitfalls of work, life and love in Manhattan.",
                "https://image.tmdb.org/t/p/w185/f496cm9enuEsZkSPzCwnTESEK5s.jpg",
                "https://image.tmdb.org/t/p/w185/l0qVZIpXtIo7km9u5Yqh0nKPOr5.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                456,
                "The Simpsons",
                "1989-12-17",
                7.6,
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "https://image.tmdb.org/t/p/w185/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "https://image.tmdb.org/t/p/w185/adZ9ldSlkGfLfsHNbh37ZThCcgU.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                83125,
                "Cursed",
                "2020-07-16",
                7.5,
                "In this fresh take on the Arthurian legend, teenager Nimue joins forces with mercenary Arthur on a quest to find Merlin and deliver an ancient sword.",
                "https://image.tmdb.org/t/p/w185/uzUPwWSAheYKdavFCcod9M6y2rf.jpg",
                "https://image.tmdb.org/t/p/w185/wrLC5kx0nEq9U0MyJD7dnOT6m5F.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                4614,
                "NCIS",
                "2003-09-23",
                7.0,
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "https://image.tmdb.org/t/p/w185/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                "https://image.tmdb.org/t/p/w185/4VuCtYBvZGq6Rk3gloigwlsTefE.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                1434,
                "Family Guy",
                "1999-01-31",
                6.7,
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "https://image.tmdb.org/t/p/w185/q3E71oY6qgAEiw6YZIHDlHSLwer.jpg",
                "https://image.tmdb.org/t/p/w185/4oE4vT4q0AD2cX3wcMBVzCsME8G.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                60735,
                "The Flash",
                "2014-10-07",
                7.4,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://image.tmdb.org/t/p/w185/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "https://image.tmdb.org/t/p/w185/jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                1622,
                "Supernatural",
                "2005-09-13",
                7.9,
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                "https://image.tmdb.org/t/p/w185/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "https://image.tmdb.org/t/p/w185/nVRyd8hlg0ZLxBn9RaI7mUMQLnz.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                12971,
                "Dragon Ball Z",
                "1989-04-26",
                8.1,
                "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
                "https://image.tmdb.org/t/p/w185/dBsDWUcdfbuZwglgyeeQ9ChRoS4.jpg",
                "https://image.tmdb.org/t/p/w185/ydf1CeiBLfdxiyNTpskM0802TKl.jpg",
                false
            )
        )
        tv.add(
            TvshowEntityDomain(
                1416,
                "Grey's Anatomy",
                "2005-03-27",
                7.8,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/w185/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                "https://image.tmdb.org/t/p/w185/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                false
            )
        )
        return tv
    }
    suspend fun getAllDummyTvShow():Flow<Resource<List<TvshowEntityDomain>>>{
        return flow {
            val result= generateDummyTv()
            if (result.isNotEmpty()){
                emit(Resource.Success(result))
            }else if(result.isEmpty()){
                emit(Resource.Error("Kosong"))
            }
        }
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse(
                27205,
                "Cobb, a skilled thief who commits corporate espionage by infiltrating the subconscious of his targets is offered a chance to regain his old life as payment for a task considered to be impossible: \"inception\", the implantation of another person's idea into a target's subconscious.",
                "Inception",
                "https://image.tmdb.org/t/p/w185/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg",
                "https://image.tmdb.org/t/p/w185/s3TBrRGB1iav7gFOCNx3H31MoES.jpg",
                "2010-07-15",
                "8.3"
            )
        )
        movies.add(
            MovieResponse(
                583083,
                "With college decisions looming, Elle juggles her long-distance romance with Noah, changing relationship with bestie Lee and feelings for a new classmate.",
                "The Kissing Booth 2",
                "https://image.tmdb.org/t/p/w185/mb7wQv0adK3kjOUr9n93mANHhPJ.jpg",
                "https://image.tmdb.org/t/p/w185//wO5QSWZPBT71gMLvrRex0bVc0V9.jpg",
                "2020-07-24",
                "8.2"
            )
        )
        movies.add(
            MovieResponse(
                516486,
                "A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the “Black Pit” to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.",
                "Greyhound",
                "https://image.tmdb.org/t/p/w185/kjMbDciooTbJPofVXgAoFjfX8Of.jpg",
                "https://image.tmdb.org/t/p/w185/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg",
                "2020-07-10",
                "7.5"
            )
        )
        return movies
    }

    fun generateRemoteDummyTvshow(): List<TvshowResponse> {
        val tvshows = ArrayList<TvshowResponse>()
        tvshows.add(
            TvshowResponse(
                456,
                "The Simpsons",
                "1989-12-16",
                7.6,
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "https://image.tmdb.org/t/p/w185/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "https://image.tmdb.org/t/p/w185/adZ9ldSlkGfLfsHNbh37ZThCcgU.jpg"
            )
        )
        tvshows.add(
            TvshowResponse(
                2734,
                "Law & Order: Special Victims Unit",
                "1999-09-20",
                7.3,
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                "https://image.tmdb.org/t/p/w185/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "https://image.tmdb.org/t/p/w185/cD9PxbrdWYgL7MUpD9eOYuiSe2P.jpg"
            )
        )
        tvshows.add(
            TvshowResponse(
                1668,
                "Friends",
                "1994-09-22",
                8.2,
                "The misadventures of a group of friends as they navigate the pitfalls of work, life and love in Manhattan.",
                "https://image.tmdb.org/t/p/w185/f496cm9enuEsZkSPzCwnTESEK5s.jpg",
                "https://image.tmdb.org/t/p/w185/l0qVZIpXtIo7km9u5Yqh0nKPOr5.jpg"
            )
        )
        return tvshows
    }

    /*fun generateDummyFavoriteMovie(movie: MovieEntityDomain, favorite: Boolean): MovieEntityDomain {
        movie.favorite = favorite
        return MovieEntityDomain(
            movie.id,
            movie.title,
            movie.date,
            movie.rate,
            movie.overview,
            movie.path,
            movie.backdropPath,
            movie.favorite
        )
    }

    fun generateDummyFavoriteTvshow(tvshow: TvshowEntityDomain, favorite: Boolean): TvshowEntityDomain {
        tvshow.favorite = favorite
        return TvshowEntityDomain(
            tvshow.id,
            tvshow.title,
            tvshow.date,
            tvshow.rate,
            tvshow.overview,
            tvshow.path,
            tvshow.backdropPath,
            tvshow.favorite
        )
    }*/
}