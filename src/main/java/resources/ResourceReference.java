package resources;

//A reference from one resource to another
public interface ResourceReference extends Type {
	private Code type; //The name of one of the resource types defined in this specification to identify the type of the resource being referenced
	private Uri uriId; //A literal URL that resolves to the location of the resource. The URL may be relative or absolute. Relative Ids contain the logical id of the resource. This reference is version independent - it points to the latest version of this resource
	private Uri version; //A literal URL that resolves to the location of a particular version of the resource. The URL may be relative or absolute. Relative Ids contain the logical version id of the resource.
	private String display; //Plain text narrative that identifies the resource in addition to the resource reference
}