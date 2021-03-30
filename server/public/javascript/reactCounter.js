console.log("Running React Counter");

const ce = React.createElement
const addCountRoute = document.getElementById("addCountRoute").value;
const getCountRoute = document.getElementById("getCountRoute").value;
class ReactCounterComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0,
    }
  }
  render() {
    return ce('div', null, 'React Counter!',
      ce('br'),
      ce('h2', null, 'Counter: '),
      ce('span', {id: "count"}, this.state.counter),
      ce('br'),
      ce('button', {onClick: (e) => this.increaseCount(e)}, "Increment Count")
    );
  }
  
  componentDidMount() {
    this.getCount();
  }

  getCount(e) {
    fetch(getCountRoute).then(response => {
        return response.json();
    }).then(json => {
        this.setState({counter: json});
    });
  }

  increaseCount(e) {
    fetch(addCountRoute).then(response => {
        return response.json();
    }).then(json => {
        console.log(json);
        this.setState({counter: json});
    });
  }
}

ReactDOM.render(
  ce(ReactCounterComponent, null, null),
  document.getElementById('react-root')
);