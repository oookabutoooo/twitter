import React from "react";
import TweetBox from "./components/TweetBox";

ReactDOM.render(
<TweetBox　url="/json" pollInterval={2000}/>,
    document.getElementById('content')
)
