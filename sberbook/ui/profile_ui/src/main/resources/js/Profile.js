import React from "react";
import Background from "./Background";
import ButtonBar from './ButtonBar.js';
import Card from "./Card.js"

class Profile extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            cards: []
        };
    }

    componentDidMount() {
        const cardData = [
            {
                id:1,
                data: {
                    name: "Petya Karasikov",
                    login: "@karasb",
                    tweet: "Классно сгоняли на рыбалку",
                    likes: 332,
                    retweets: 87,
                    date: new Date().toUTCString()
                }
                
            },
            {
                id:2,
                data: {
                    name: "Vasya Ivanov",
                    login: "@coolBoy",
                    tweet: "Сегодня я выгулял свою собаку",
                    likes: 148,
                    retweets: 51,
                    date: new Date(1432523394222).toUTCString()
                }
            },
            {
                id:3,
                data: {
                    name: "Korol Artur",
                    login: "@prostoTsarb",
                    tweet: "Танцую танго!",
                    likes: 157,
                    retweets: 81,
                    date: new Date(132523394222).toUTCString()
                }
            }
        ];
        this.setState({
            cards: cardData
        })
            
    }

    render() {
        const cardsComponents = this.state.cards.map(item => {
            return (
                <Card key={item.id} data={item.data}/>
            )
        });

        return (
            <div className="container">
                <div className="row justify-content-md-center" >
                    <Background/>
                    <ButtonBar/> 
                    <div style={{marginTop: "30px"}}>
                        {cardsComponents}
                    </div>                  
                </div>
            </div>
        )
    }
}

export default Profile;