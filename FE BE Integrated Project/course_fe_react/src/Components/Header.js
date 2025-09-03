import{
    Card,
    CardBody,
    CardTitle,
    CardSubtitle,
    CardText,
    CardFooter,
    Button,
    Container,
} from "reactstrap";
function Header({name, title, color}){
    return(
        <div>
            <Card className="my-2 bg-success">
                <CardBody>
                <h1 className="text-center my-2">Welcome to Courses Application</h1>
                </CardBody>
            </Card>
            
        </div>
    );
}

export default Header;